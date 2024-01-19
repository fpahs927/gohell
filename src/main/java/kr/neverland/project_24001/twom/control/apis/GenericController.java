package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandPageInformationForListDTO;
import kr.neverland.project_24001.twom.control.dto.response.*;
import kr.neverland.project_24001.twom.control.dto.response.obj.BoardContentDetailDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.BoardListInfoDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.SubscriptionDTO;
import kr.neverland.project_24001.twom.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/neverland/apis/mbd/generic")
@RestController
public class GenericController {
    @Autowired
    private CommonService commonService;

    @GetMapping("/board_content_detail")  //q&a
    public GenericNeverlandResponseDTO getBoardContentDetail(@RequestParam Long userid,
                                                             @RequestParam String sessionCode,
                                                             @RequestParam Long boardId) {
        commonService.QnAInfo(userid, sessionCode, boardId);

        BoardContentDetailDTO boardList = new BoardContentDetailDTO();

        return GetBoardContentDetailResponseDTO.create(GetBoardContentDetailResponseDTO.class, true, "")
                .setBoardContentDetail(boardList).toResponseDTO();
    }

    //append board content

    @GetMapping("/board_list") //공지사항
    public GenericNeverlandResponseDTO getBoardList(@RequestParam Long userid,
                                                    @RequestParam String sessionCode,
                                                    @RequestParam String searchCondition,
                                                    @RequestParam Integer pageNumber,
                                                    @RequestParam Integer pageSize) {
        ArrayList<BoardListInfoDTO> boardListInfoDTO = new ArrayList<>(0);

        return GetBoardListResponseDTO.create(GetBoardListResponseDTO.class, true, "")
                .setPageInfo(new NeverLandPageInformationForListDTO()
                        .setPageCurrentNumber(pageNumber).setPageSize(pageSize))
                .setBoardListInfoDTOList(boardListInfoDTO).toResponseDTO();
    }

    @GetMapping("/get_subscription_terms")
    public GenericNeverlandResponseDTO getSubscriptionTerms(@RequestParam String dataTime
            , @RequestParam String termcode) {
        SubscriptionDTO getSubscriptionDTO = new SubscriptionDTO();

        return GetSubscriptionTermResponseDTO.create(GetSubscriptionTermResponseDTO.class, true, "")
                .setSubscriptionTerm(getSubscriptionDTO).toResponseDTO();
    }
}
