package kr.neverland.project_24001.twom.control.apis;

import kr.neverland.project_24001.twom.control.dto.response.GenericNeverlandResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetMyNotificationListResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.GetMyStoreListResponseDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyNotificationDataDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyStoreInfoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/neverland/apis/mbd/notification")
@RestController
public class NotificationController {
//외부 인터페이스 사용
    @GetMapping("/my_notification_data")
    public GenericNeverlandResponseDTO getMyNotificationData(@RequestParam Long userId
                                                        , @RequestParam String sessionCode){
        ArrayList<MyNotificationDataDTO> infoList=new ArrayList<MyNotificationDataDTO>(0);

        return GetMyNotificationListResponseDTO.create(GetMyNotificationListResponseDTO.class,true,"")
                .setMyNotificationList(infoList).toResponseDTO();
    }
}
