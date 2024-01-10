package kr.neverland.project_24001.twom.control.dto.request;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameDataUpdateStatusRequestDTO {
    private NeverLandLoginInfoDTO user;

    private Long MyGameDataId;

    private String newStatus;
}
