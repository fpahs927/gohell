package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.common.NeverLandPageInformationForListDTO;
import kr.neverland.project_24001.twom.control.dto.request.GameDataCreateStatusRequestDTO;
import kr.neverland.project_24001.twom.control.dto.request.GameDataUpdateStatusRequestDTO;
import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetMyGameDataListResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyGameDataInfoDTO;
import kr.neverland.project_24001.twom.service.inner.GameDataService;
import kr.neverland.project_24001.twom.service.out.GameInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/neverland/apis/mbd/gamedata")
@RestController
public class GameDataController {

    @Autowired
    private GameDataService gameDataService;
    @Autowired
    private GameInfoService gameInfoService;

    @PostMapping("/create_game_data_status")
    public GenericNeverlandResponseDTO createGameDataStatus(@RequestBody GameDataCreateStatusRequestDTO p1){
        return GenericNeverlandResponseDTO.Unimplemented;
    }
    @DeleteMapping("/delete_game_data/{userid}/{sessionCode}/{myGameDataId}")
    public GenericNeverlandResponseDTO deleteGameData(@PathVariable Long userid, @PathVariable String sessionCode, @PathVariable Long myGameDataId){
        return GenericNeverlandResponseDTO.test("작업 중",userid,sessionCode,myGameDataId);
    }
    @GetMapping("/my_game_data_list")
    public GenericNeverlandResponseDTO getMyGameDataList(@RequestParam Long userid,
                                                         @RequestParam String sessionCode,
                                                         @RequestParam String status,
                                                         //의뢰인지 출력인지 카트인지 구분 (MyGameStatus.status)
                                                         @RequestParam String searchCondition,
                                                         @RequestParam Integer pageNumber,
                                                         @RequestParam Integer pageSize){
        ArrayList<MyGameDataInfoDTO> dataInfoList = new ArrayList<MyGameDataInfoDTO>(0);


        gameDataService.getMyGameDataInfoList(dataInfoList);

        for (MyGameDataInfoDTO dto :dataInfoList)
            gameInfoService.setGameInfoByAllotId(dto.getSelectGame());

        return GetMyGameDataListResponseDTO.create(GetMyGameDataListResponseDTO.class,true,"")
                .setPageInfo(new NeverLandPageInformationForListDTO()
                            .setPageCurrentNumber(pageNumber).setPageSize(pageSize))
                .setMyGameDataInfoDTO(dataInfoList).toResponseDTO();
    }

    //get_game_data_game_number_list

    @PostMapping("/update_game_data_status")
    public GenericNeverlandResponseDTO updateGameDataStatus(@RequestBody GameDataUpdateStatusRequestDTO p1){
        return GenericNeverlandResponseDTO.Unimplemented;
    }

}
