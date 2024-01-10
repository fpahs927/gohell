package kr.neverland.project_24001.twom.control.dto.request;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandLoginInfoDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StoreInfoAddMyRequestDTO {
    private NeverLandLoginInfoDTO user;

    private String storeCode;

}
