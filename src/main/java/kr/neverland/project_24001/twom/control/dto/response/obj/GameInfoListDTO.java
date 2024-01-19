package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class GameInfoListDTO {
    private long dateTime=System.currentTimeMillis();
    private List<GameInfoDTO> data;

    @Override
    public String toString() {
        if(data==null){
            return "GameInfoListDTO{null game data}";
        }
        return "GameInfoListDTO{"+data.size()+" items/"+new Date(dateTime)+"}";

    }
}
