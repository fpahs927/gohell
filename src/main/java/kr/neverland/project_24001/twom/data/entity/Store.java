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
public class Store extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long storeId;

    private String storeType;
    private String storeLevel;
    private String storeName;
    private String storeCode;
    private String address;
    private String phoneNumber;

    @OneToMany
    @JoinColumn(name="store_id_of_mygameresult")
    List<MyGameResult> myGameResultList;
}
