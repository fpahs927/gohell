package kr.neverland.project_24001.twom.data.repository;

import kr.neverland.project_24001.twom.control.dto.response.obj.BoardContentDetailDTO;
import kr.neverland.project_24001.twom.data.entity.MyBoard;
import kr.neverland.project_24001.twom.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MyBoardRepository extends JpaRepository<MyBoard, Long> {

    List<MyBoard> findByBoardId(Long BoardId);

    void findByUserIdAndCategoryName(Long userId, String searchCondition);

    List<MyBoard> findByCategoryName(String searchCondition);
}
