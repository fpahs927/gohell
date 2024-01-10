package kr.neverland.project_24001.twom.control.dto.request;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameDataCreateStatusRequestDTO {
    private NeverLandLoginInfoDTO user;

    private String [][] gameAllotCodesAndSelection;
    private Long amount;
    private String unitType;

    private String defaultStatus;

}
