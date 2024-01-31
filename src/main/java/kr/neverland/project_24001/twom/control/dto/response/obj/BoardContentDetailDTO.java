package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardContentDetailDTO {
    private long boardId;
    private String title;
    private String nickName;
    private String datetime;
    private String boardType;
    private String categoryName;
}
