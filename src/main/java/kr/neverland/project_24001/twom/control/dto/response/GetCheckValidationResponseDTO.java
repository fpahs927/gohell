package kr.neverland.project_24001.twom.control.dto.response;

import kr.neverland.project_24001.twom.control.dto.response.obj.CheckEmailContainsDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class GetCheckValidationResponseDTO extends GenericNeverlandResponseDTO.Result {
    @Setter
    private Object request;
    private String isTest = "true";

    private List<CheckEmailContainsDTO> CheckEmailContainsDto;
}

