package controller.board;

import data.dto.BoardAnswerDto;
import data.service.BoardAnswerService;
import data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//무조건 json 데이터로 반환하는 컨트롤러 100% ajax 형식이거나, react에서 사용
@RestController
@RequestMapping("/board")
public class BoardAnswerController {
    @Autowired
    private BoardAnswerService answerService;
    @Autowired
    private MemberService memberService;

    @PostMapping("/ansInsert")
    public void insertAnswer(
            @RequestParam int num,
            @RequestParam String content,
            HttpSession session
    ){
        // 로그인한 아이디 얻기
        String myid = (String) session.getAttribute("loginid");
        //아이디에 해당하는 이름얻기
        String writer = memberService.getMemberById(myid).getName();
        //dto 에 필요한 데이터 넣기
        //setter 역할
        BoardAnswerDto dto = BoardAnswerDto.builder().
                myid(myid).
                writer(writer).
                content(content).
                num(num).build();
        //db insert
        answerService.insertAnswer(dto);
    }


}
