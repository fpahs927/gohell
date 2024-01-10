package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Notification  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notificationId;



    @ManyToOne
    @JoinColumn(name = "user_id_of_notification")
    private User user;
}
