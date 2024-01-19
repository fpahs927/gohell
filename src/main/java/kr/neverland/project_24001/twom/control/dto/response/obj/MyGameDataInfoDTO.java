package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Accessors(chain = true)
public class MyGameDataInfoDTO {
    private String id; //실제로는 선택 구분값 <-"MyGameData.MyGameDataId"이안에 넣으면 될듯 ㅋ
    private String number; //마찬가지 선택 구분값

    private String closingDate; //"MyGameResult.timeOutDate"이안에 넣으면 될듯 ㅋ (=GameInfoDTO.closingDate)

    private String state; //"MyGameStatus.status"
    private String gameDataResult;//MyGameDataInfoSelectedGameAllotDTO의 값을 정산하여 처리

    private List<MyGameDataInfoSelectedGameAllotDTO> selectGame;

}
