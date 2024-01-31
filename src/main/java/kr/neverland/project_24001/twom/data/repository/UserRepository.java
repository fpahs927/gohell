package kr.neverland.project_24001.twom.data.repository;
import jakarta.persistence.metamodel.SingularAttribute;
import kr.neverland.project_24001.twom.data.entity.User;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndDeleteDateIsNull(String email);
    List<User> findByPasswordAndDeleteDateIsNull(String password);
    User findFirstByEmailAndPasswordAndDeleteDateIsNullOrderByCreateDateDesc(String email, String password);
}
