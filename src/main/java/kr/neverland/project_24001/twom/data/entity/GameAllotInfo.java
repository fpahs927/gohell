package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class GameAllotInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameAllotInfoId;

    private double allotRateHomeTeam;
    private double allotRateArrayTream;
    private double allotRateExtra;
    private String allotmentType;
    private String extraValue01;
    private String extraValue02;
    private String extraValue03;


    @ManyToOne
    @JoinColumn(name = "gameallot_id_of_gameallotitem")
    private GameInfo parentGameInfo;

    @OneToOne
    @JoinColumn(name = "gameallot_id_of_gameallotresult")
    private GameAllotInfoResult result;
}
