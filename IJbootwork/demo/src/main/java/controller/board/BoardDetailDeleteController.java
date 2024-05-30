package controller.board;

import data.dto.BoardAnswerDto;
import data.dto.ReBoardDto;
import data.service.BoardAnswerService;
import data.service.MemberService;
import data.service.ReBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardDetailDeleteController {
    @Autowired
    private ReBoardService reBoardService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private BoardAnswerService ansService;

    @GetMapping("/detail")
    public String detail(
            @RequestParam int num,
            @RequestParam int currentPage,
            Model model
    )
    {
        //조회수 증가
        reBoardService.updateReadcount(num);
        //num 에 해당하는 글 가져오기
        ReBoardDto dto=reBoardService.getData(num);
        //해당 아이디가 갖고 있는 프로필 사진 가져오기
        String profile_photo=memberService.getMemberById(dto.getMyid()).getPhoto();
        List<BoardAnswerDto> list = ansService.selectAllAnswer(num);
        model.addAttribute("profile_photo", profile_photo);
        model.addAttribute("dto", dto);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("list", list);

        return "board/detailpage";
    }
    @GetMapping("/alist")
    @ResponseBody
    public Map<String,Object> alist(@RequestParam int num){
        Map<String,Object> map=new HashMap<>();
        map.put("list",ansService.selectAllAnswer(num));
        map.put("photolist",ansService.selectAnswer(num));
         return map;
    }
    @ResponseBody
    @GetMapping("/adelete")
    public String deleteAnswer(@RequestParam int aidx){
        ansService.deleteAnswer(aidx);
        return "{}";
    }

}
