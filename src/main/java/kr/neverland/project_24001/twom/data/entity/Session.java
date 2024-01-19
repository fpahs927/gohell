package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@Entity

public class Session extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sessionId;


    private String sessionCode;
    private LocalDateTime sessionTimeout;

    @ManyToOne
    @JoinColumn(name = "user_id_of_session")
    private User user;
}
