package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.request.GameDataCreateStatusRequestDTO;
import kr.neverland.project_24001.twom.control.dto.request.GameDataUpdateStatusRequestDTO;
import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetMyGameDataListResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyGameDataInfoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/neverland/apis/mbd/gamedata")
@RestController
public class GameDataController {

    @PostMapping("/create_game_data_status")
    public GenericNeverlandResponseDTO createGameDataStatus(@RequestBody GameDataCreateStatusRequestDTO p1){
        return GenericNeverlandResponseDTO.Unimplemented;
    }
    @DeleteMapping("/delete_game_data/{userid}/{sessionCode}/{myGameDataId}")
    public GenericNeverlandResponseDTO deleteGameData(@PathVariable Long userid, @PathVariable String sessionCode, @PathVariable Long myGameDataId){
        return GenericNeverlandResponseDTO.test("작업 중",userid,sessionCode,myGameDataId);
    }
    @GetMapping("/my_game_data_list")
    public GenericNeverlandResponseDTO getMyGameDataList(@RequestParam Long myGameDataId,
                                                         @RequestParam int amount,
                                                         @RequestParam String reservedTime,
                                                         @RequestParam String memo,
                                                         @RequestParam String store){
        ArrayList<MyGameDataInfoDTO> dataInfoList = new ArrayList<MyGameDataInfoDTO>(0);
        return GetMyGameDataListResponseDTO.create(GetMyGameDataListResponseDTO.class,true,"")
                .setMyGameDataInfoDTO(dataInfoList).toResponseDTO();
    }
    @PostMapping("/update_game_data_status")
    public GenericNeverlandResponseDTO updateGameDataStatus(@RequestBody GameDataUpdateStatusRequestDTO p1){
        return GenericNeverlandResponseDTO.Unimplemented;
    }

}
