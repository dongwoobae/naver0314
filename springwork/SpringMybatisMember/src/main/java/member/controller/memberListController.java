package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import member.service.MemberService;

@Controller
@RequestMapping("/member") //같은 폴더 안에 여러개의 맵핑을 하고 싶으면 이렇게 상위 폴더 맵핑을
//정해줄 수 있다. 해당 class 내의 mapping들은 /member의 하위폴더 위치로 맵핑된다.
@RequiredArgsConstructor
public class memberListController {
	//@Autowired
	@NonNull
	private MemberService memberService;
	
	@GetMapping("/list") // 이렇게 하면 /member/list 로 가진다.
	public String list(Model model) {
		int totalCount;
		//전체 목록 가져오기
		List<MemberDto> list=memberService.getAllMembers();
		
		totalCount=memberService.getTotalCount();
		
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list",list);
		
		return "member/memberlist";
	}
	
	@GetMapping("/detail")
	public String detail(
			@RequestParam("myid") String myid,
			Model model) {
		MemberDto dto = memberService.getOneMember(myid);
		model.addAttribute("dto",dto);
		return "/member/detail";
	}
	@ResponseBody
	@GetMapping("/delete")
	public String deleteMember(
			@RequestParam int num
			) {
		memberService.deleteMember(num);
		return "{}";
	}
	
}
