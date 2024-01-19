package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;

@Getter
public class BoardListInfoDTO {
    private long boardId;
    private String title;
    private String content;
    private String nickName;
    private String datetime;
    private String boardType;
    private String categoryName;
}
