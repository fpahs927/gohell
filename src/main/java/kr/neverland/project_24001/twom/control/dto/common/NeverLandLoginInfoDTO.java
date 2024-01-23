package kr.neverland.project_24001.twom.control.dto.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class NeverLandLoginInfoDTO {
    private Long userId;
    private String sessionCode;

}
