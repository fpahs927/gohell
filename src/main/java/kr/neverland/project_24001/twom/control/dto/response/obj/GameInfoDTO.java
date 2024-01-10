package kr.neverland.project_24001.twom.control.dto.response.obj;

import lombok.Getter;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Getter
public class GameInfoDTO {
    private String unitType;
    private LocalDateTime localDateTime;
}
