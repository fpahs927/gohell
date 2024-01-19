package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
public class GameInfoDTO {
    private String dataId;
    private String closingDate;
    private String leagueName;
    private String state;
    private String homeTeam;
    private String awayTeam;

    private List<GameAllotDTO> data;

    public boolean contains(String allotid) {
        for (GameAllotDTO dto:data){
            if(dto.getAllotId().equals(allotid)){
                return true;
            }
        }
        return false;
    }
}
