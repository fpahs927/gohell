package kr.neverland.project_24001.twom.control.dto.request;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountChangePasswordRequestDTO {
    private NeverLandLoginInfoDTO user;


    private String email;

    private String prePassword;

    private String type; //0.로그인 상태에서 변경, 1.email로 변경, 2.기존 패스워드로 변경

    private String newPassword;
}
