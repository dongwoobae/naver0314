package bit.repository.board;

import bit.data.board.BoardCommentDto;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BoardCommentDao {
    private BoardCommentDaoInter daoInter;
    //추가
    public void insertComment(BoardCommentDto boardCommentDto) {
        daoInter.save(boardCommentDto);
    }
    //삭제
    public void deleteComment(@Param("idx") Long idx){
        daoInter.deleteById(idx);
    }
    //목록
    public List<BoardCommentDto> findByBoardId(@Param("boardNum") Long boardNum){
        return daoInter.findByBoardId(boardNum);
    }
    //수정
    public void updateBoardComment(@Param("idx") Long idx, @Param("comment") String comment){
        daoInter.updateComment(idx,comment);
    }
    //비밀번호 체크
    public boolean pwCheck(@Param("idx") Long idx, @Param("cpass") String cpass){
        return daoInter.pwCheck(idx,cpass)==1;
    }

}
