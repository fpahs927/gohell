package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.request.AccountChangePasswordRequestDTO;
import kr.neverland.project_24001.twom.control.dto.request.AccountCreateRequestDTO;
import kr.neverland.project_24001.twom.control.dto.request.AccountLoginRequestDTO;
import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandSessionResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetCheckValidationResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetMyAccountInfoResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.CheckEmailContainsDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyAllInfoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/neverland/apis/mbd/account")
@RestController
public class AccountController {
    @PostMapping("/change_password")
    public GenericNeverlandResponseDTO changePassword(@RequestBody AccountChangePasswordRequestDTO p1){
        return GenericNeverlandResponseDTO.test("작업 중",p1);
    }

    @GetMapping("/check_email_contains")
    public GenericNeverlandResponseDTO checkEmailContains(@RequestParam String email){
        ArrayList<CheckEmailContainsDTO> checkEmailList= new ArrayList<CheckEmailContainsDTO>(0);
        return GetCheckValidationResponseDTO.create(GetCheckValidationResponseDTO.class, true, "")
                .setCheckEmailContainsDto(checkEmailList).toResponseDTO();
    }

    @PostMapping("/create_account")
    public GenericNeverlandResponseDTO createAccount(@RequestBody AccountCreateRequestDTO p1){
        return GenericNeverlandResponseDTO.Unimplemented;
    }

    @DeleteMapping("/disposeAccount/{userid}/{sessionCode}")
    public GenericNeverlandResponseDTO disposeAccount(@PathVariable Long userid, @PathVariable String sessionCode){
        return GenericNeverlandResponseDTO.test("작업 중",userid,sessionCode);
    }

    @PostMapping("/login_account")
    public GenericNeverlandResponseDTO loginAccount(@RequestBody AccountLoginRequestDTO p1){
        return GenericNeverlandSessionResponseDTO
                .create(GenericNeverlandSessionResponseDTO.class, true,"로그인 성공[테스트]")
                .setUser(new NeverLandLoginInfoDTO()
                        .setUserId(777L)
                        .setSessionCode("test")
                ).toResponseDTO();
    }

    @GetMapping("/my_info")
    public GenericNeverlandResponseDTO getMyInfo(@RequestParam Long userid){
        ArrayList<MyAllInfoDTO> myAllInfoList = new ArrayList<MyAllInfoDTO>();
        return GetMyAccountInfoResponseDTO.create(GetMyAccountInfoResponseDTO.class,true,"")
                .setMyAllInfoDTOList(myAllInfoList).toResponseDTO();
    }
}
