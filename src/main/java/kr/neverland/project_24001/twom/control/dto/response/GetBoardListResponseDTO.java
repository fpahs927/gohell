package kr.neverland.project_24001.twom.control.dto.response;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandPageInformationForListDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.BoardListInfoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class GetBoardListResponseDTO extends GenericNeverlandResponseDTO.Result {
    @Setter
    private Object request;
    private String isTest = "true";

    private NeverLandPageInformationForListDTO pageInfo;
    private List<BoardListInfoDTO> boardListInfoDTOList;
}
