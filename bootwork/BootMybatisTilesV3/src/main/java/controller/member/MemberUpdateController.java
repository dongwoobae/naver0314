package controller.member;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberUpdateController {
	@NonNull
	private MemberService memberService;
	
	@ResponseBody
	@PostMapping("/member/updatephoto")
	public Map<String, String> uploadPhoto(
			@RequestParam int num,
			@RequestParam("upload") MultipartFile myfile,
			HttpServletRequest request
			){
		Map<String, String> map= new HashMap<>();
		String savePath=request.getSession().getServletContext().getRealPath("/save");
		String ext=myfile.getOriginalFilename().split("\\.")[1];
		String photo=UUID.randomUUID()+"."+ext;

		try {
			myfile.transferTo(new File(savePath+"/"+photo));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("photo", photo);
		memberService.updatePhoto(num, photo);
		return map;
	}
	@ResponseBody
	@GetMapping("/member/deletepasswd")
	public Map<String, String> deleteMember(@RequestParam String passwd,
			@RequestParam int num
			) {
		Map<String, String> map=new HashMap<>();
		boolean success=memberService.deleteMember(passwd, num);
		if(success) {
			map.put("status", "success");
		}else {
			map.put("status", "fail");
		}
				
		return map;
	}
	@PostMapping("/member/update")
	public String updateMember(
			@ModelAttribute MemberDto dto,
			@RequestParam int num
			){
		
		memberService.updateMember(dto);
		
		return "redirect:/member/detail?num=" + num;
	}
	
	@GetMapping("/member/updateform")
	public String updateFormMember(@RequestParam int num
			,Model model) {
		
		MemberDto dto=memberService.getOneMember(num);
		
		 model.addAttribute("dto",dto);
		return "member/updateform";
	}
	
	
	
}
