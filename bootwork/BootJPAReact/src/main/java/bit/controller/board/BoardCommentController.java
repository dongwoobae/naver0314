package bit.controller.board;

import bit.data.board.BoardCommentDto;
import bit.data.board.BoardDto;
import bit.service.board.BoardCommentService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot/boardcomment")
public class BoardCommentController {
    private final BoardCommentService boardCommentService;

    @GetMapping("/insert")
    public void commentInsert(@RequestParam("boardNum") Long boardNum,
                              @RequestParam("nickname") String nickname,
                              @RequestParam("comment") String comment
                              ){
        //이렇게 주면 boardNum이 안들어감
//        boardCommentService.insertComment(dto);        
        BoardDto boardDto=BoardDto.builder().boardNum(boardNum).build();
        BoardCommentDto dto= BoardCommentDto.builder()
                .nickname(nickname)
                .comment(comment)
                .boardDto(boardDto).
                build();

        boardCommentService.insertComment(dto);
    }

    @DeleteMapping("/delete")
    public void commentDelete(@RequestParam("idx") Long idx){
        boardCommentService.deleteComment(idx);
    }

    @GetMapping("/list")
    public List<BoardCommentDto> list(@RequestParam("boardNum") Long boardNum){
        return boardCommentService.findByBoardId(boardNum);
    }

    @GetMapping("/update")
    public void commentUpdate(@RequestParam("idx") Long idx, @RequestParam("comment") String comment){
        boardCommentService.updateBoardComment(idx,comment);
    }
}
