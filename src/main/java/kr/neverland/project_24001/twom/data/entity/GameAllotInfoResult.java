package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class GameAllotInfoResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameAllotInfoResultId;

    private String	winAllotmentSelection	;
    private double	winRate	;


}
