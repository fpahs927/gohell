package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.response.*;
import kr.neverland.project_24001.twom.control.dto.response.obj.BoardContentDetailDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.BoardListInfoDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.getSubscriptionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/neverland/apis/mbd/generic")
@RestController
public class GenericController {
    @GetMapping("/board_content_detail")  //q&a
    public GenericNeverlandResponseDTO getBoardContentDetail(@RequestParam Long userId){
        ArrayList<BoardContentDetailDTO> boardList = new ArrayList<BoardContentDetailDTO>(0);
        return GetBoardContentDetailResponseDTO.create(GetBoardContentDetailResponseDTO.class,true,"")
                .setBoardContentDetailList(boardList).toResponseDTO();
    }
    @GetMapping("/board_list") //공지사항
    public GenericNeverlandResponseDTO getBoardList(@RequestParam Long userId){
        ArrayList<BoardListInfoDTO> boardListInfoDTO = new ArrayList<>(0);
        return GetBoardListResponseDTO.create(GetBoardListResponseDTO.class,true,"")
                .setBoardListInfoDTOList(boardListInfoDTO).toResponseDTO();
    }
    @GetMapping("/get_subscription_terms")
    public GenericNeverlandResponseDTO getSubscriptionTerms(@RequestParam String dataTime){
        ArrayList<getSubscriptionDTO> getSubscriptionDTO=new ArrayList<getSubscriptionDTO>(0);

        return GetSubscriptionTermResponseDTO.create(GetSubscriptionTermResponseDTO.class,true,"")
                .setGetSubscriptionDTOList(getSubscriptionDTO).toResponseDTO();
    }
}
