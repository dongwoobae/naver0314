package mycar.controller;

import lombok.RequiredArgsConstructor;
import mycar.data.MyCarCommentDto;
import mycar.data.MyCarDto;
import mycar.repository.MyCarCommentDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mycar")
public class MyCarCommentController {
    private final MyCarCommentDao dao;

    @GetMapping("/addcomment")
    public void addComment(@RequestParam("num") Long num,
                           @RequestParam("comment") String comment) {
        MyCarDto dto = MyCarDto.builder().num(num).build();
        MyCarCommentDto commentDto = MyCarCommentDto.builder().
                comment(comment).
                myCar(dto).
                build();
    //댓글추가
        dao.insertComment(commentDto);
    }

    @GetMapping("/commentlist")
    public List<MyCarCommentDto> commentList(@RequestParam("num") Long num) {
        return dao.selectAllComments(num);
    }
    @GetMapping("/commentdelete")
    public void deleteComment(@RequestParam("idx")int idx) {
        dao.deleteComment(idx);
    }
}
