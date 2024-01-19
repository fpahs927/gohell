package kr.neverland.project_24001.twom.control.dto.response.obj;

import jakarta.persistence.EntityManager;
import kr.neverland.project_24001.twom.control.apis.AccountController;
import lombok.Getter;

@Getter
public class CheckEmailContainsDTO {
    String email;

    public CheckEmailContainsDTO(String email) {
        this.email = email;
    }
}
