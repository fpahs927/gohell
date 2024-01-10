package kr.neverland.project_24001.twom.control.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountLoginRequestDTO {
    private String email;
    private String password;
}
