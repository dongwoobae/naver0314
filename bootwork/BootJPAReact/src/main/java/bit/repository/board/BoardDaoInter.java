package bit.repository.board;

import bit.data.board.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardDaoInter extends JpaRepository<BoardDto,Long> {
    //사진 수정을 안 할 경우
    @Modifying
    @Transactional
    @Query(value = "update reactboard set content=:#{#dto.content},title=:#{#dto.title} where board_num=:#{#dto.boardNum}"
    ,nativeQuery = true)
    public void updateBoardWithOutPhoto(@Param("dto") BoardDto dto);
    @Modifying
    @Transactional
    @Query(value = "update reactboard set readcount=readcount+1 where board_num=:boardNum",nativeQuery = true)
    public void updateReadCount(@Param("boardNum") Long boardNum);
    @Query(value = "select count(*) from reactboard where board_num=:boardNum and pass=:pass",
    nativeQuery = true)
    public int isEqualPass(@Param("boardNum") Long boardNum,@Param("pass") String pass);
}
