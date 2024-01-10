package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class MyGameDataItem  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long myGameDataItemId;

    private String gameAllotmentId;
    private String gameAllotmentSelection;

    @ManyToOne
    @JoinColumn(name = "mygamedata_id_of_mygamedataitem")
    private MyGameData parentGameData;
}
