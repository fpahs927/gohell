package kr.neverland.project_24001.twom.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class TestService {
//
//    @Autowired
//    private TestRepository userTestRepository;
//    @Autowired
//    private TestRepository<MyBoard> boardTestRepository;

    @PostConstruct
    public void prevContruct(){
//        Log logger= LogFactory.getLog(TestService.class);
//
//
//        logger.info("test->repository");
//        userTestRepository.findAll();
//        boardTestRepository.findAll();
    }
}
