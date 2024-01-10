package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class MyStore  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long myStoreId;

    private boolean isDefaultStore;

    @ManyToOne
    @JoinColumn(name = "user_id_of_my_store")
    private User user;

    @OneToOne
    @JoinColumn(name = "store_id_of_my_store")
    private Store store;

    @Override
    protected void onPrePersist() {
        isDefaultStore=false;
    }
}
