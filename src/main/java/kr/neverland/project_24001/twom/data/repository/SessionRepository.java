package kr.neverland.project_24001.twom.data.repository;

import kr.neverland.project_24001.twom.data.entity.Session;
import kr.neverland.project_24001.twom.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    List<Session> findByUser_UserIdAndSessionCodeAndDeleteDateIsNullOrderByCreateDateDesc(Long userId, String sessionCode);
}
