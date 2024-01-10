package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class MyGameData extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long myGameDataId;

    private long amount;
    private String unitType; //돈 "won"인지 뭔지


    @ManyToOne
    @JoinColumn(name = "user_id_of_mygamedata")
    private User user;

    @OneToMany
    @JoinColumn(name = "mygamedata_id_of_mygamedataitem")
    List<MyGameDataItem> itemList;

    @OneToMany
    @JoinColumn(name = "mygamedata_id_of_mygameresult")
    List<MyGameResult> resultList;

    @OneToMany
    @JoinColumn(name = "mygamedata_id_of_mygamestatus")
    List<MyGameStatus> statusList;
}
