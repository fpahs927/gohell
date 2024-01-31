package kr.neverland.project_24001.twom.service.common;

import kr.neverland.project_24001.twom.control.dto.response.obj.BoardContentDetailDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.BoardListInfoDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyAccountInfoDTO;
import kr.neverland.project_24001.twom.control.dto.response.obj.MyStoreInfoDTO;
import kr.neverland.project_24001.twom.data.entity.MyBoard;
import kr.neverland.project_24001.twom.data.entity.User;
import kr.neverland.project_24001.twom.data.repository.MyBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommonService {
    @Autowired
    private MyBoardRepository myboardRepository;

    public BoardContentDetailDTO getBoardContentDetail(String userLevel, Long userId, Long boardId) {
        //--->주면됨 ? categoryName, title,
        User user = new User();
        //boardId로 myboard를 가져오고
        List<MyBoard> myBoardList = myboardRepository.findByBoardId(boardId);
        MyBoard myBoard = new MyBoard();
        BoardContentDetailDTO boardContentDetailDTO = new BoardContentDetailDTO();
        boardContentDetailDTO.setCategoryName("subscriptionTerms");

        String category = boardContentDetailDTO.getCategoryName();
        if (!myBoardList.isEmpty()) {
            if ((category != null) & category.equals("private-question")) { //categoryName = private-question 인 경우
                if (!userLevel.equals("admin")) {  // userLevel이 admin이 아닌경우 -->userId 체크해야됨
                    if (user.getUserId() != userId) {
                        throw new RuntimeException("userId가 없습니다");
                    }
                } else {   // userLevel이 admin인 경우 걍 주면됨
                    System.out.println("방가방가햄토리");
                    myBoard.setBoardId(boardContentDetailDTO.getBoardId());
                    myBoard.setContent(boardContentDetailDTO.getNickName());
                    myBoard.setCategoryName(boardContentDetailDTO.getCategoryName());
                    myBoard.setTitle(boardContentDetailDTO.getTitle());
                }
            } else {//categoryName = private-question 아닌 경우 걍 주면됨
                System.out.println("방가방가강아지");
                myBoard.setBoardId(boardContentDetailDTO.getBoardId());
                myBoard.setContent(boardContentDetailDTO.getNickName());
                myBoard.setCategoryName(boardContentDetailDTO.getCategoryName());
                myBoard.setTitle(boardContentDetailDTO.getTitle());
            }
            myboardRepository.save(myBoard);
            return boardContentDetailDTO;
        }
        return null; //비어있으니깐
    }

    public ArrayList<BoardListInfoDTO> getBoardList(String userLevel, Long userId, String searchCondition) {
        //목록 전체를 조회해서 보여준다
        ArrayList<BoardListInfoDTO> list = new ArrayList<>(0);
        //공지사항(announcement), QNA(question-and-answer), 1:1문의(private-question)
           //categoryName = searchCondition
        List<MyBoard> myBoardList = null;
        User user = new User();
        if (searchCondition.startsWith("subscriptionTerms:")) {
            //전체를 다주면됨
           // myBoard.setCategoryName(searchCondition);
            myBoardList = myboardRepository.findByCategoryName(searchCondition);
        }
        if (searchCondition.contains("announcement")) {//categoryName = announcement
            myBoardList=myboardRepository.findByCategoryName(searchCondition);
            //전체를 다주면됨
        }
        if (searchCondition.contains("question-and-answer")) {//categoryName = question-and-answer
            myBoardList =myboardRepository.findByCategoryName(searchCondition); //question에 해당하는 데이터들만 조회하는건지
                     //findAll해서 조회해야하는건지? 물어보기
            //전체를 다주면됨
        }
        if (searchCondition.contains("private-question")) {//categoryName = private-question
            if(userLevel.contains("admin")){ //userLevel이 admin인 경우 전체 조회
                myBoardList =myboardRepository.findByCategoryName(searchCondition);
            }else{ //userLevel 이 admin이 아닌경우 자기것만  (userId)를 기준으로 조회
                myboardRepository.findByUserIdAndCategoryName(userId, searchCondition);
            }
        }
        for (MyBoard board : myBoardList) {
            BoardListInfoDTO dto = new BoardListInfoDTO();
            dto.setTitle(board.getTitle());
            dto.setContent(board.getContent());
            dto.setBoardId(board.getBoardId());
            dto.setNickName(user.getNickName());
            dto.setDatetime(dto.getDatetime());
            dto.setBoardType(board.getBoardType());
            dto.setCategoryName(dto.getCategoryName());

            list.add(dto);
        }

        return list;
    }
}
