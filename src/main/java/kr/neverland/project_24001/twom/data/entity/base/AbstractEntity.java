package kr.neverland.project_24001.twom.data.entity.base;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@MappedSuperclass
public abstract class AbstractEntity {

    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private LocalDateTime deleteDate;
    private String cause;
    private String tag;


    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
        modifyDate = null;
        deleteDate =null;
        cause="자동생성";

        onPrePersist();
    }

    protected void onPrePersist() {
    }
}
