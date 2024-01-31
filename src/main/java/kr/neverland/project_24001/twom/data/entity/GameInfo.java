package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
public class GameInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameInfoId;

    private String displayText;

    @OneToMany
    @JoinColumn(name = "gameallot_id_of_gameallotitem")
    private List<GameAllotInfo> itemList;

    @OneToOne
    @JoinColumn(name = "result_id_of_gameinforesult")
    private GameInfoResult result;
}
