package kr.neverland.project_24001.twom.data.repository;

import kr.neverland.project_24001.twom.data.entity.MyStore;
import kr.neverland.project_24001.twom.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<MyStore, Long> {
}
