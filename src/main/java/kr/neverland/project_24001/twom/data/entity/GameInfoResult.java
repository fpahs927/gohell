package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class GameInfoResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameInfoResultId;
    private long scoreHomeTeam;
    private long scoreArrayTeam;

}
