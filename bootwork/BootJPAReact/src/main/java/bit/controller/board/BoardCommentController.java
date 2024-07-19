package bit.controller.board;

import bit.data.board.BoardCommentDto;
import bit.data.board.BoardDto;
import bit.service.board.BoardCommentService;
import bit.service.board.ClientUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot/boardcomment")
public class BoardCommentController {
    private final BoardCommentService boardCommentService;

    @PostMapping("/insert")
    public void commentInsert(@RequestParam("boardNum") Long boardNum,
                              @RequestParam("nickname") String nickname,
                              @RequestParam("comment") String comment,
                              @RequestParam("cpass") String cpass,
                              HttpServletRequest request
                              ){
        //이렇게 주면 boardNum이 안들어감
//        boardCommentService.insertComment(dto);
        String loginIp= ClientUtils.getRemoteIP(request);
        BoardDto boardDto=BoardDto.builder().boardNum(boardNum).build();
        BoardCommentDto dto= BoardCommentDto.builder()
                .loginip(loginIp)
                .cpass(cpass)
                .nickname(nickname)
                .comment(comment)
                .boardDto(boardDto).
                build();

        boardCommentService.insertComment(dto);
    }
    @DeleteMapping("delete/{idx}")
    public void commentDelete(@PathVariable("idx") Long idx){
        boardCommentService.deleteComment(idx);
    }

    @GetMapping("/pwcheck")
    public Map<String,String> pwCheck(@RequestParam("idx") Long idx, @RequestParam("cpass") String cpass){
        boolean check= boardCommentService.pwCheck(idx,cpass);
        Map<String,String> map=new HashMap<>();
        if(check){
            map.put("result","confirm");
            return map;
        }else {
            map.put("result","cancel");
            return map;
        }
    }

    @GetMapping("/list")
    public List<BoardCommentDto> list(@RequestParam("boardNum") Long boardNum){
        return boardCommentService.findByBoardId(boardNum);
    }

    @PutMapping("update/{idx}")
    public void commentUpdate(@PathVariable("idx") Long idx, @RequestParam("comment") String comment){
        boardCommentService.updateBoardComment(idx,comment);
    }
}
