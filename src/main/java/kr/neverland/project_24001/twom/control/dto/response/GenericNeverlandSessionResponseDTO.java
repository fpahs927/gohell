package kr.neverland.project_24001.twom.control.dto.response;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class GenericNeverlandSessionResponseDTO extends GenericNeverlandResponseDTO.Result {
    private NeverLandLoginInfoDTO user;
}
