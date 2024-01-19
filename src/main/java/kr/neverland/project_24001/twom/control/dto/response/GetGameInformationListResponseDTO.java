package kr.neverland.project_24001.twom.control.dto.response;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandPageInformationForListDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.GameInfoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class GetGameInformationListResponseDTO extends GenericNeverlandResponseDTO.Result {
    private NeverLandPageInformationForListDTO pageInfo;
    private List<GameInfoDTO> gameInfoDTO;
}
