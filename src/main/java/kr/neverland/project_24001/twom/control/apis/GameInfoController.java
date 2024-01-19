package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandPageInformationForListDTO;
import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetGameInformationListResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.GameInfoDTO;
import kr.neverland.project_24001.twom.service.out.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RequestMapping("/neverland/apis/mbd/gameinfo")
@RestController
public class GameInfoController {

    @Autowired
    private GameInfoService gameInfoService;

    //외부 인터페이스 사용
    //보안 문제를 고민할것
    @GetMapping("/game_info_list")
    public GenericNeverlandResponseDTO getGameInfoList(@RequestParam Long userid,
                                                       @RequestParam String sessionCode,
                                                       @RequestParam String searchCondition,
                                                       @RequestParam Integer pageNumber,
                                                       @RequestParam Integer pageSize) {

        ArrayList<GameInfoDTO> gameInfoList = new ArrayList<GameInfoDTO>(0);

        gameInfoService.getGameInfoList(gameInfoList);
        pageNumber=1;
        pageSize=gameInfoList.size();

        return GetGameInformationListResponseDTO.create(GetGameInformationListResponseDTO.class,true,"")
                .setPageInfo(new NeverLandPageInformationForListDTO()
                        .setPageCurrentNumber(pageNumber).setPageSize(pageSize).setPageMaxNumber(pageNumber).setMaxDataCount(pageSize))
                            .setGameInfoDTO(gameInfoList).toResponseDTO();
    }
}
