package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class MyGameResult  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long myGameResultId;
//    private long userId;

    private String resultType;
    private String memo;
    private String details;
    private LocalDateTime reservedDate;
    private boolean useReservedDate;
    private LocalDateTime timeOutDate;
    private boolean useTimeout;



    @ManyToOne
    @JoinColumn(name = "store_id_of_mygameresult")
    private Store targetStore;

    @ManyToOne //mappedBy를 걸어야되나 확인하기
    @JoinColumn(name = "mygamedata_id_of_mygameresult")
    private MyGameData parentGameData;
}
