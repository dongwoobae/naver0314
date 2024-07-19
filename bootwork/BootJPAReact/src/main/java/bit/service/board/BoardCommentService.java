package bit.service.board;

import bit.data.board.BoardCommentDto;
import bit.repository.board.BoardCommentDao;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardCommentService {
    private BoardCommentDao dao;

    public void insertComment(BoardCommentDto boardCommentDto){
        dao.insertComment(boardCommentDto);
    }
    public void deleteComment(@Param("idx") Long idx){
        dao.deleteComment(idx);
    }
    public List<BoardCommentDto> findByBoardId(@Param("boardNum") Long boardNum){
        return dao.findByBoardId(boardNum);
    }
    public void updateBoardComment(@Param("idx") Long idx, @Param("comment") String comment){
        dao.updateBoardComment(idx,comment);
    }
}
