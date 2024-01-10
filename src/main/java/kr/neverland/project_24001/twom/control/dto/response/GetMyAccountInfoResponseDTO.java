package kr.neverland.project_24001.twom.control.dto.response;

import kr.neverland.project_24001.twom.control.dto.response.obj.MyAllInfoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class GetMyAccountInfoResponseDTO extends GenericNeverlandResponseDTO.Result {
    @Setter
    private Object request;
    private String isTest = "true";
    private List<MyAllInfoDTO> myAllInfoDTOList;
}
