package kr.neverland.project_24001.twom.service.common;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import kr.neverland.project_24001.twom.control.dto.request.AccountCreateRequestDTO;
import kr.neverland.project_24001.twom.data.entity.User;
import kr.neverland.project_24001.twom.data.repository.SessionRepository;
import kr.neverland.project_24001.twom.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        userRepository.save(user);

        long id=user.getUserId();
        System.out.println("여기는 서비스 단의 닉네임:" + user.getNickName() + "/그리고 나는 이메일" + user.getEmail()
                + "/그리고 나는 이메일" +id);
        return id;
    }
    public void validateDuplicateStudent(String email) throws Exception {  //중복 검증
        List<User> existStudent = userRepository.findByEmail(email);
        if(existStudent.isEmpty()) {
            return;
        }
        System.out.println("중복된 이메일입니다");
        existStudent.clear();
        throw new Exception("이미 존재하는 이름");
    }

    public void changePassword(Long userId, String sessionCode, String prevPassword, String newPassword) {
//로그인 한 상태에서 기존패스워드와 새로운 패스워드를 입력
        //userId와 sessioncode를 검증
        //특정 user를 userId로 찾음
        //찾은 다음에 변경

        System.out.print("얘는 세션코드인데 뭐가 나오는지 한번 보자" + sessionCode);
        Optional<User> findUserId = userRepository.findById(userId);
        findUserId.ifPresent(user -> {
            if(prevPassword.equals(user.getPassword())){
                user.setPassword(newPassword);
                userRepository.save(user);
                System.out.print("되는지만 보자");
            }
            else{
                System.out.print("좆됌");
            }
        });
    }
    public NeverLandLoginInfoDTO login(String email, String password) { //로그인 얘부터하고 changePassword 해라 
        //login 구현할 때 세션코드가 만들어지고
        //jwt 세션
        Long userId; //email과 password로 찾아야됨
        String sessionCode; //session이 비어있으니까 생성해야됨 ->

        NeverLandLoginInfoDTO newNeverLandLoginInfoDTO=new NeverLandLoginInfoDTO();
//        newNeverLandLoginInfoDTO.setUserId();
//        newNeverLandLoginInfoDTO.setSessionCode();
//        userRepository.save();
        return newNeverLandLoginInfoDTO;
    }

//    public List<User> findUser() {
//        System.out.println("나미가 테스트할거임" + userRepository.findAll());
//        return userRepository.findAll();
//    }
}
