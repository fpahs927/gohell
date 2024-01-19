package kr.neverland.project_24001.twom.control.dto.response;

import kr.neverland.project_24001.twom.control.dto.response.obj.BoardContentDetailDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyNotificationDataDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class GetBoardContentDetailResponseDTO extends GenericNeverlandResponseDTO.Result {
    @Setter
    private Object request;
    private String isTest = "true";

    private BoardContentDetailDTO boardContentDetail;
}
