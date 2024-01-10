package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetGameInformationListResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetMyGameDataListResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.GameInfoDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RequestMapping("/neverland/apis/mbd/gameinfo")
@RestController
public class GameInfoController {
    //외부 인터페이스 사용
    @GetMapping("/game_info_list")
    public GenericNeverlandResponseDTO getGameInfoList(@RequestParam String unitType,
                                                       @RequestParam LocalDateTime localDateTime) {
        ArrayList<GameInfoDTO> gameInfoList = new ArrayList<GameInfoDTO>(0);

        return GetGameInformationListResponseDTO.create(GetGameInformationListResponseDTO.class,true,"")
                .setGameInfoDTO(gameInfoList).toResponseDTO();
    }
}
