package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class MyAccountInfoDTO {
    private String userName;
    private String email;
    private String nickName;
    private String phoneNumber;
    private String userLevel;

    private LocalDateTime agreementDate001;
    private LocalDateTime agreementDate002;
    private LocalDateTime agreementDate003;
    private LocalDateTime agreementDate004;

    private List<MyStoreInfoDTO> myStoreList;
}
