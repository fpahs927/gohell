package kr.neverland.project_24001.twom.control.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class AccountCreateRequestDTO {
    private String userName;
    private String nickName;
    private String eMail;
    private String password;
    private LocalDateTime agreementDate001;
    private LocalDateTime agreementDate002;
    private LocalDateTime agreementDate003;
    private LocalDateTime agreementDate004;
}
