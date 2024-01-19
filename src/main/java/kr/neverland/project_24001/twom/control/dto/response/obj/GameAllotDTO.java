package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameAllotDTO {
    private String allotId;
    private String gameNo;
    private String win;
    private String draw;
    private String lose;
    private String extraText;
}
