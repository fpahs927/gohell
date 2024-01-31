package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.request.StoreInfoAddMyRequestDTO;
import kr.neverland.project_24001.twom.control.dto.request.StoreInfoSetDefaultRequestDTO;
import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetMyStoreListResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyStoreInfoDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/neverland/apis/mbd/storeinfo")
@RestController
public class StoreInfoController {

    //StoreService
//    @PostMapping("/add_store")
//    public GenericNeverlandResponseDTO addStore(@RequestBody StoreInfoAddRequestDTO p1){
//        return GenericNeverlandResponseDTO.Unimplemented;
//    }
//    @GetMapping("/store_list")
//    public GenericNeverlandResponseDTO getStoreList(@RequestParam Long userId){
//        ArrayList<StoreInfoDTO> infoList=new ArrayList<StoreInfoDTO>(0);
//
//        return GetStoreListResponseDTO.create(GetStoreListResponseDTO.class,true,"")
//                .setMyStoreList(infoList).toResponseDTO();
//    }
    @PostMapping("/add_my_store")
    public GenericNeverlandResponseDTO addMyStore(@RequestBody StoreInfoAddMyRequestDTO p1){
        return GenericNeverlandResponseDTO.Unimplemented;
    }
    @GetMapping("/my_store_list")
    public GenericNeverlandResponseDTO getMyStoreList(@RequestParam Long userId){
        ArrayList<MyStoreInfoDTO> infoList=new ArrayList<MyStoreInfoDTO>(0);

        return GetMyStoreListResponseDTO.create(GetMyStoreListResponseDTO.class,true,"")
                .setMyStoreList(infoList).toResponseDTO();
    }
    @PostMapping("/set_default_store")
    public GenericNeverlandResponseDTO setDefaultStore(@RequestBody StoreInfoSetDefaultRequestDTO p1){
        return GenericNeverlandResponseDTO.test("작업 중",p1);
    }
}
