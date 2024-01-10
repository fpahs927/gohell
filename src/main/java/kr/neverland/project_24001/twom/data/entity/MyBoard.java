package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class MyBoard extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long boardId;

    private String boardType;
    private String categoryName;
    private String title;
    private String content;
    private String attachment;


    @ManyToOne
    @JoinColumn(name = "user_id_of_board")
    private User user;
}
