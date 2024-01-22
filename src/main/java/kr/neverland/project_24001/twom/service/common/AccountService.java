package kr.neverland.project_24001.twom.service.common;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import kr.neverland.project_24001.twom.control.dto.request.AccountCreateRequestDTO;
import kr.neverland.project_24001.twom.data.entity.Session;
import kr.neverland.project_24001.twom.data.entity.User;
import kr.neverland.project_24001.twom.data.repository.SessionRepository;
import kr.neverland.project_24001.twom.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static kr.neverland.project_24001.twom.data.entity.QSession.session;

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

        long id = user.getUserId();
        System.out.println("여기는 서비스 단의 닉네임:" + user.getNickName() + "/그리고 나는 이메일" + user.getEmail()
                + "/그리고 나는 이메일" + id);
        return id;
    }

    public void validateDuplicateStudent(String email) throws Exception {  //중복 검증
        Optional<User> existStudent = userRepository.findByEmail(email);
        if (existStudent.isPresent()) {
            return;
        }
        System.out.println("중복된 이메일입니다");
        //  existStudent.clear();
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
            if (prevPassword.equals(user.getPassword())) {
                user.setPassword(newPassword);
                userRepository.save(user);
                System.out.print("되는지만 보자");
            } else {
                System.out.print("좆됌");
            }
        });
    }

    public NeverLandLoginInfoDTO login(String email, String password) { //로그인 얘부터하고 changePassword 해라
        //login 구현할 때 세션코드가 만들어지고

        Optional<User> matchingUser = userRepository.findByEmail(email);
        Optional<User> matchingPassword = userRepository.findByPassword(password);

        //Long userId; //email과 password로 찾아야됨 (해결)
        //애초에 session 안에는 아무값도 없는데 뭘 넣어서 만들어야하는거지?

        NeverLandLoginInfoDTO newNeverLandLoginInfoDTO = new NeverLandLoginInfoDTO();

        matchingUser.ifPresent(finduser -> {
            matchingPassword.filter(findPassword -> finduser.getPassword().equals(password))
                    .ifPresent(findPassword -> {
                        Long userId= finduser.getUserId();
                        newNeverLandLoginInfoDTO.setUserId(userId);

                        String sessionCode = newNeverLandLoginInfoDTO.getSessionCode();
                        newNeverLandLoginInfoDTO.setSessionCode(sessionCode);

                        System.out.println("지금은 userId는?" + userId + "sessionCode는?" + sessionCode);

                        sessionRepository.findById(userId);
//                        newNeverLandLoginInfoDTO.setSessionCode(newNeverLandLoginInfoDTO.getSessionCode());


                        ////////////////////////////////////////////////////////////////////////



                        Session testSession = new Session();
                        System.out.println("테스트2" + newNeverLandLoginInfoDTO.setSessionCode(testSession.getSessionCode()));
                        testSession.setUser(finduser);
                        testSession.setSessionCode(sessionCode);
                        testSession.setSessionCode(newNeverLandLoginInfoDTO.getSessionCode());
                        sessionRepository.save(testSession);
                        /////////////////////////////////////////////////////////////////////////////

                        newNeverLandLoginInfoDTO.setSessionCode(testSession.getSessionCode());
                        newNeverLandLoginInfoDTO.setUserId(testSession.getSessionId());
                        sessionRepository.save(testSession);

                        ///////////////////////////////////////////////////////////////////////////

                        sessionRepository.findById(userId).ifPresentOrElse(
                                existsession -> {
                                    newNeverLandLoginInfoDTO.setSessionCode(testSession.getSessionCode());
                                    newNeverLandLoginInfoDTO.setUserId(testSession.getSessionId());
                                    sessionRepository.save(testSession);
                                },
                                ()->{ //없다

                                }
                        );
//                        sessionRepository.findByUserId(userId);
//                                .ifPresentOrElse(
//                                //저장된 게 있다면
//                                        session -> {
//                                            newNeverLandLoginInfoDTO.setSessionCode(session.getSessionCode());
//                                            sessionRepository.save(session);
//                                        },
//                                        ()->{ //없다면
//                                            Session newSession = new Session();
//                                            newSession.setSessionCode(newSession.getSessionCode());
//                                            newSession.setSessionId(newSession.getSessionId());
//                                            sessionRepository.save(newSession);
//                                            System.out.print("새로운 새션을 만들어 저장했습니다");
//                                        }
//                                );

                    });
        });


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
