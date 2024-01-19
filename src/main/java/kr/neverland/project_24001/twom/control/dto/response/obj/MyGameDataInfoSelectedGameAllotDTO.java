package kr.neverland.project_24001.twom.control.dto.response.obj;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyGameDataInfoSelectedGameAllotDTO {
    private String allotid; //MyGameDataItem.gameAllotmentId
    private String leagueName; //GameInfoDTO.leagueName
    private String homeTeam; //GameInfoDTO.homeTeam
    private String awayTeam; //GameInfoDTO.awayTeam
    private String prediction;//MyGameDataItem.gameAllotmentSelection

    private String allotResult;//MyGameResult

    private Float rate; //GameInfoAllotDTO에서 조합하여 연산
}
