package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class MyBoard extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String boardType;
    private String categoryName;
    private String title;
    private String content;
    private String attachment;

    private LocalDateTime replyDate;
    private String replyType;


    @ManyToOne
    @JoinColumn(name = "user_id_of_board")
    private User user;
}
