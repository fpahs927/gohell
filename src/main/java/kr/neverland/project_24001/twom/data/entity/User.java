package kr.neverland.project_24001.twom.data.entity;

import jakarta.persistence.*;
import kr.neverland.project_24001.twom.data.entity.base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User extends AbstractEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    private String userName;
    private String email;
    private String nickName;
    private String password;

    private String userLevel;
    private String phoneNumber;

    private LocalDateTime agreementDate001;
    private LocalDateTime agreementDate002;
    private LocalDateTime agreementDate003;
    private LocalDateTime agreementDate004;


    @OneToMany
    @JoinColumn(name="user_id_of_my_store")
    List<MyStore> myStoreList;

    @OneToMany
    @JoinColumn(name="user_id_of_mygamedata")
    List<MyGameData> myGameDataList;

    @OneToMany
    @JoinColumn(name="user_id_of_board")
    List<MyBoard> myBoardList;
}
