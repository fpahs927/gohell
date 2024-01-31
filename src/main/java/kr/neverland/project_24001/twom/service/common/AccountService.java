package kr.neverland.project_24001.twom.service.common;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import kr.neverland.project_24001.twom.control.dto.request.AccountCreateRequestDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyAccountInfoDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyStoreInfoDTO;
import kr.neverland.project_24001.twom.data.entity.MyStore;
import kr.neverland.project_24001.twom.data.entity.Session;
import kr.neverland.project_24001.twom.data.entity.User;
import kr.neverland.project_24001.twom.data.repository.SessionRepository;
import kr.neverland.project_24001.twom.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;

    public Long createJoin(AccountCreateRequestDTO createUser) throws Exception {  //회원가입
        //계정 생성시 검증로직이 필요
        validateDuplicateStudent(createUser.getEmail());
        User user = new User();
        user.setUserName(createUser.getUserName());
        user.setNickName(createUser.getNickName());
        user.setEmail(createUser.getEmail());
        user.setPassword(createUser.getPassword());
        user.setAgreementDate001(createUser.getAgreementDate001());
        user.setAgreementDate002(createUser.getAgreementDate002());
        user.setAgreementDate003(createUser.getAgreementDate003());
        user.setAgreementDate004(createUser.getAgreementDate004());

        userRepository.save(user);

        return user.getUserId();
    }

    public void validateDuplicateStudent(String email) throws Exception {  //중복 검증
        Optional<User> existStudent = userRepository.findByEmailAndDeleteDateIsNull(email);
        if (existStudent.isPresent()) {
            System.out.println("중복된 이메일입니다");
            throw new Exception("이미 존재하는 이름");
        }
        System.out.println("사용가능한 이메일입니다");
    }

    public boolean changePassword(Long userId, String sessionCode, String prevPassword, String newPassword) {
        User user= _getSession(userId,sessionCode,true,15);
        if(user!=null){
            if(user.getPassword().equals(prevPassword)){
                user.setPassword(newPassword);
                userRepository.save(user);
                return true;
            }
            System.out.println("비번이 틀렸구나["+userId+"/"+sessionCode+"/"+prevPassword+"]");
            return false;
        }
        return false;
    }
    public boolean validateSession(Long userId, String sessionCode) {
        return null != _getSession(userId, sessionCode,false,-1);
    }
    public MyAccountInfoDTO getSession(Long userId, String sessionCode, boolean updateSessionTimeout, int timeoutMinutes) {
        User user=  _getSession(userId,sessionCode,updateSessionTimeout,timeoutMinutes);

        if(user==null)
            return null;

        MyAccountInfoDTO dto= new MyAccountInfoDTO();

        dto.setUserName(user.getUserName());
        dto.setNickName(user.getNickName());
        dto.setEmail(user.getEmail());
        dto.setUserLevel(user.getUserLevel());
        dto.setPhoneNumber(user.getPhoneNumber());

        List<MyStoreInfoDTO> myStoreInfoDTOS=new ArrayList<>(0);
        MyStoreInfoDTO thisStore;
        for (MyStore store :user.getMyStoreList()){
            myStoreInfoDTOS.add(thisStore=new MyStoreInfoDTO());
            thisStore.setAddress(store.getStore().getAddress());
            thisStore.setCode(store.getStore().getStoreCode());
            thisStore.setTel(store.getStore().getPhoneNumber());
            thisStore.setLevel(store.getStore().getStoreLevel());
//            thisStore.setStatus(store.getStore().getStoreStatus());   "뭔지모르겠는데?"나중에 확인할것
        }
        dto.setMyStoreList(myStoreInfoDTOS);

        return dto;
    }
    private User _getSession(Long userId, String sessionCode,boolean updateSessionTimeout,int timeoutMinutes) {
        List<Session> sessions = sessionRepository.findByUser_UserIdAndSessionCodeAndDeleteDateIsNullOrderByCreateDateDesc(userId, sessionCode);

        LocalDateTime now= LocalDateTime.now();
        if(!sessions.isEmpty()){
            System.out.println("session 찾음["+userId+"/"+sessionCode+"]");

            for (Session s : sessions){
                if(s.getSessionTimeout()==null)
                {
                    System.out.println("session 시간초과["+userId+"/"+sessionCode+"]");
                    return null;
                }
                if(s.getSessionTimeout().isAfter(now))
                {
                    System.out.println(
                            s.getUser().getUserName()+"/"+s.getSessionCode()+"/"+s.getSessionTimeout()
                    );

                    if(updateSessionTimeout) {
                        LocalDateTime sessionTimeout = LocalDateTime.of(LocalDate.now(), LocalTime.now());
                        sessionTimeout = sessionTimeout.plusMinutes(timeoutMinutes);
                        s.setSessionTimeout(sessionTimeout);

                        sessionRepository.save(s);
                    }
                    return s.getUser();
                }
            }
            System.out.println("session 시간초과["+userId+"/"+sessionCode+"]");
            return null;
        }
        System.out.println("session 못찾음["+userId+"/"+sessionCode+"]");
        return null;
    }

    public NeverLandLoginInfoDTO login(String email, String password,int timeoutMinutes) {
        //login 구현할 때 세션코드가 만들어지고
        //db에 한번만 접근할 수 있게끔
        User finduser = userRepository.findFirstByEmailAndPasswordAndDeleteDateIsNullOrderByCreateDateDesc(email, password);

        System.out.println("userRepository->findFirstByEmailAndPasswordAndDeleteDateIsNullOrderByCreateDateDesc");

        if(finduser==null){
            return null;
        }
        NeverLandLoginInfoDTO newNeverLandLoginInfoDTO = new NeverLandLoginInfoDTO();
        Long userId= finduser.getUserId();
        newNeverLandLoginInfoDTO.setUserId(userId);


        //기존에 발급했던 session은 expire하지는 않음
        Session session = new Session();

        String sessionCode = Session.createSessionCode(userId);
        newNeverLandLoginInfoDTO.setSessionCode(sessionCode);
        newNeverLandLoginInfoDTO.setUserLevel(finduser.getUserLevel());
        System.out.println("지금은 userId는?" + userId + "sessionCode는?" + sessionCode);

        LocalDateTime sessionTimeout=LocalDateTime.of(LocalDate.now(), LocalTime.now());
        sessionTimeout= sessionTimeout.plusMinutes(timeoutMinutes);

        session.setSessionTimeout(sessionTimeout);
        session.setUser(finduser);
        session.setSessionCode(sessionCode);
        sessionRepository.save(session);


        return newNeverLandLoginInfoDTO;
    }
}