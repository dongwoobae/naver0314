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
@RequestMapping("/member") //���� ���� �ȿ� �������� ������ �ϰ� ������ �̷��� ���� ���� ������
//������ �� �ִ�. �ش� class ���� mapping���� /member�� �������� ��ġ�� ���εȴ�.
@RequiredArgsConstructor
public class memberListController {
	//@Autowired
	@NonNull
	private MemberService memberService;
	
	@GetMapping("/list") // �̷��� �ϸ� /member/list �� ������.
	public String list(Model model) {
		int totalCount;
		//��ü ��� ��������
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
