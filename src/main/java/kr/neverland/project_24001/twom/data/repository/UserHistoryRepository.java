package kr.neverland.project_24001.twom.data.repository;

import kr.neverland.project_24001.twom.data.entity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
