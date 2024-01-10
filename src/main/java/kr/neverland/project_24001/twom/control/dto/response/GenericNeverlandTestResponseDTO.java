package kr.neverland.project_24001.twom.control.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class GenericNeverlandTestResponseDTO extends GenericNeverlandResponseDTO.Result {
    @Setter
    private Object request;
    private String isTest="true";

}
