package controller.member;

import data.dto.MemberDto;
import data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberListController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping({"/list"})
	public String memberList(Model model) {
		int totalCount = memberService.getTotalCount();
		model.addAttribute("totalCount",totalCount);
		List<MemberDto> list = memberService.getTotalMember();
		model.addAttribute("list",list);
		return "member/memberlist";
	}

	@GetMapping("/detail")
	public String getOneMember(
			@RequestParam("num") int num,
			Model model
							   ){
		MemberDto dto = memberService.getMemberByNum(num);
		model.addAttribute("dto",dto);
		return "member/detailpage";

	}

}
