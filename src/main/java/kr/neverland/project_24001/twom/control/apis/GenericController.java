package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandPageInformationForListDTO;
import kr.neverland.project_24001.twom.control.dto.response.*;
import kr.neverland.project_24001.twom.control.dto.response.obj.BoardContentDetailDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.BoardListInfoDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyAccountInfoDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.SubscriptionDTO;
import kr.neverland.project_24001.twom.service.common.AccountService;
import kr.neverland.project_24001.twom.service.common.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@RequestMapping("/neverland/apis/mbd/generic")
@RestController
public class GenericController {
    @Autowired
    private CommonService commonService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/board_content_detail")  //하나의 제목을 선택했을때 세부적인 내용을 표시하기 위하여 제공
    public GenericNeverlandResponseDTO getBoardContentDetail(@RequestParam Long userId,
                                                             @RequestParam String sessionCode,
                                                             @RequestParam Long boardId) {
        MyAccountInfoDTO accountInfoDTO;

        if ((accountInfoDTO = accountService.getSession(userId, sessionCode, true, 10)) == null) {
            return GetBoardListResponseDTO
                    .create(GetBoardListResponseDTO.class, false, "유효하지않은 접근입니다.").toResponseDTO();
        }

        BoardContentDetailDTO boardContentDetailDTO = commonService.getBoardContentDetail(accountInfoDTO.getUserLevel(), userId, boardId);

        if (boardContentDetailDTO == null) {
            return GetBoardListResponseDTO
                    .create(GetBoardListResponseDTO.class, false, "불러오는데 실패했습니다").toResponseDTO();
        }

        return GetBoardContentDetailResponseDTO.create(GetBoardContentDetailResponseDTO.class, true, "q&a입니다")
                .setBoardContentDetail(boardContentDetailDTO).toResponseDTO();
    }

    //append board content

    @GetMapping("/board_list") //목록 자체를 조회해서 제공
    public GenericNeverlandResponseDTO getBoardList(@RequestParam Long userId,
                                                    @RequestParam String sessionCode,
                                                    @RequestParam String searchCondition,
                                                    @RequestParam Integer pageNumber,
                                                    @RequestParam Integer pageSize) {

        MyAccountInfoDTO accountInfoDTO;

        if ((accountInfoDTO = accountService.getSession(userId, sessionCode, true, 10)) == null) {
            return GetBoardListResponseDTO
                    .create(GetBoardListResponseDTO.class, false, "유효하지않은 접근입니다.").toResponseDTO();
        }

        ArrayList<BoardListInfoDTO> boardListInfoDTO = commonService.getBoardList(accountInfoDTO.getUserLevel(), userId, searchCondition);

        return GetBoardListResponseDTO.create(GetBoardListResponseDTO.class, true, "")
                .setPageInfo(new NeverLandPageInformationForListDTO()
                        .setPageCurrentNumber(pageNumber).setPageSize(pageSize))
                .setBoardListInfoDTOList(boardListInfoDTO).toResponseDTO();
    }

    @GetMapping("/get_subscription_terms") //회원가입시 약관 정보를 표시하기 위하여 제공
    public GenericNeverlandResponseDTO getSubscriptionTerms(@RequestParam String dataTime,
                                                            @RequestParam String termcode) {

        SubscriptionDTO getSubscriptionDTO = new SubscriptionDTO();

        ArrayList<BoardListInfoDTO> boardListInfoDTO =
                commonService.getBoardList(null, -1L,
                        "subscriptionTerms:" + termcode);

        //dataTime 시간과 -->createDate을 비교
        // 이전 "마지막"꺼 있는걸 주면됩니다. 1월 20일에 가입햇다. 1월 11일 약관, 1월 18일 약관 , 1월 21일 약관

        try {
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
          Date startTime = dateFormat.parse(dataTime);
       //   Date endTime = dateFormat.parse(getSubscriptionDTO.getRegistedDataTime());
          Date now = new Date();
          String lastDataTime = "";
          for(BoardListInfoDTO time : boardListInfoDTO){
            Date endTime = dateFormat.parse(String.valueOf(time));
              if(now.getTime() >= startTime.getTime() && now.getTime() < endTime.getTime()){
              break;
            }
              lastDataTime = String.valueOf(time);
          }

          getSubscriptionDTO.setRegistedDataTime(lastDataTime);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return GetSubscriptionTermResponseDTO.create(GetSubscriptionTermResponseDTO.class, true, "")
                .setSubscriptionTerm(getSubscriptionDTO).toResponseDTO();
    }
}
