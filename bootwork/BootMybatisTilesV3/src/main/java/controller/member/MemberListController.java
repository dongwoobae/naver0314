package controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.CommentDto;
import data.dto.MemberDto;
import data.service.CommentService;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class MemberListController {
	
	@NonNull
	private MemberService memberService;
	@Autowired
	private CommentService commentService;
	
	@GetMapping({"/member/list"})
	public String memberList(Model model) {
		int totalCount = memberService.getTotalCount();
		model.addAttribute("totalCount",totalCount);
		
		List<MemberDto> list = memberService.getAllMembers();
		model.addAttribute("list",list);
		
		return "member/memberlist";
	}
	
	@GetMapping("/member/detail")
	public String getOneMember(@RequestParam("num") int num,
			Model model
			){
		MemberDto dto = memberService.getOneMember(num);
		model.addAttribute("dto",dto);
		List<CommentDto> list = commentService.selectComments(num);
		model.addAttribute("list",list);
		
		return "member/detailpage";
	};
	
	
	
}
