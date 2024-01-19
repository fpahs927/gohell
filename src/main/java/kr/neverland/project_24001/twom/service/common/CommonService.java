package kr.neverland.project_24001.twom.service.common;

import kr.neverland.project_24001.twom.data.repository.MyBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {
    @Autowired
    private MyBoardRepository myboardRepository;
    public void QnAInfo(Long userid, String sessionCode, Long boardId) {
        myboardRepository.findAll();
    }
}
