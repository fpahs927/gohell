package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class MyGameStatus  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long myGameStatusId;


    private String status;
    private String charge; //처리담당


    @ManyToOne
    @JoinColumn(name = "store_id_of_mygamestatus")
    private Store targetStore;


    @ManyToOne
    @JoinColumn(name = "mygamedata_id_of_mygamestatus")
    private MyGameData parentGameData;
}
