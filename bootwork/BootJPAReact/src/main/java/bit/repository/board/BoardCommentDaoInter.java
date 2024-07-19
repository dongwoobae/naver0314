package bit.repository.board;

import bit.data.board.BoardCommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardCommentDaoInter extends JpaRepository<BoardCommentDto,Long> {
    //boardNum의 게시글에 달린 모든 댓글
    @Query(value = "select * from boardanswer where board_num=:boardNum order by idx desc",nativeQuery = true)
    public List<BoardCommentDto> findByBoardId(@Param("boardNum") Long boardNum);

    //댓글 수정
    @Modifying
    @Transactional
    @Query(value = "update boardanswer set comment=:comment where idx=:idx",nativeQuery = true)
    public void updateComment(@Param("idx") Long idx, @Param("comment") String comment);
}
