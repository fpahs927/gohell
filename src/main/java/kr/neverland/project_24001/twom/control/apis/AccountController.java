package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.request.AccountChangePasswordRequestDTO;
import kr.neverland.project_24001.twom.control.dto.request.AccountCreateRequestDTO;
import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import kr.neverland.project_24001.twom.control.dto.request.AccountLoginRequestDTO;
import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandSessionResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetCheckValidationResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetMyAccountInfoResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyAccountInfoDTO;
import kr.neverland.project_24001.twom.service.common.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/neverland/apis/mbd/account")
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/change_password")
    public GenericNeverlandResponseDTO changePassword(@RequestBody AccountChangePasswordRequestDTO password){
        //로직이 틀렸다.
        accountService.changePassword(password.getUser().getUserId(),
                                                password.getUser().getSessionCode()
                                                    ,password.getPrePassword(), password.getNewPassword());
        return GenericNeverlandResponseDTO.test("작업 중", password.getPrePassword());
    }

    @GetMapping("/check_email_contains")  //이메일 중복 여부, 이메일만 지금 값이 null값으로 들어감
    public GenericNeverlandResponseDTO checkEmailContains(@RequestParam String Email){
        try {
            accountService.validateDuplicateStudent(Email);
        } catch (Exception e) {
            return GetCheckValidationResponseDTO.create(GetCheckValidationResponseDTO.class, false, e.getMessage())
                    .toResponseDTO();
        }
        return GetCheckValidationResponseDTO.create(GetCheckValidationResponseDTO.class, true, "")
                .toResponseDTO();
    }

    @PostMapping("/create_account")    //회원가입
    public GenericNeverlandResponseDTO createAccount(@RequestBody AccountCreateRequestDTO createUser){
        try {
            accountService.createJoin(createUser);
            System.out.print("닉네임 정보" + createUser.getNickName() + "email" + createUser.getEmail());
        } catch (Exception e) {
            return GenericNeverlandResponseDTO
                        .create(false,e.getMessage())
                                    .toResponseDTO();
        }

        return GenericNeverlandResponseDTO
                        .create(true,"성공적으로 계정이 생성되었습니다.")
                            .toResponseDTO();
//        System.out.print("닉네임 정보" + createUser.getNickName() + "email" + createUser.getEmail());
    }

    @DeleteMapping("/disposeAccount/{userid}/{sessionCode}")
    public GenericNeverlandResponseDTO disposeAccount(@PathVariable Long userid, @PathVariable String sessionCode){
        return GenericNeverlandResponseDTO.test("작업 중",userid,sessionCode);
    }

    @PostMapping("/login_account")   //로그인
    public GenericNeverlandResponseDTO loginAccount(@RequestBody AccountLoginRequestDTO user){
        NeverLandLoginInfoDTO loginInfoDTO;
        loginInfoDTO= accountService.login(user.getEmail(),user.getPassword());

        return GenericNeverlandSessionResponseDTO
                .create(GenericNeverlandSessionResponseDTO.class, true,"로그인 성공[테스트]")
                .setUser(loginInfoDTO
//                        new NeverLandLoginInfoDTO()
//                        .setUserId(777L)
//                        .setSessionCode("test")
                ).toResponseDTO();
    }

    @GetMapping("/my_info")   //세션코드 유무를 몰라 sessionCode를 알아야함
    public GenericNeverlandResponseDTO getMyInfo(@RequestParam Long userid,@RequestParam String sessionCode){
        MyAccountInfoDTO myAllInfoList = new MyAccountInfoDTO();

        return GetMyAccountInfoResponseDTO.create(GetMyAccountInfoResponseDTO.class,true,"")
                .setMyAccountInfo(myAllInfoList).toResponseDTO();
    }
}
