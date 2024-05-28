package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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

import member.dto.MemberDto;
import member.service.MemberService;

@Controller
@RequestMapping("/member")
public class memberUpdateController {
	@Autowired
	private MemberService memberService;
	
	@ResponseBody
	@PostMapping("/updatephoto")
	public Map<String, String> updatePhoto(
			@RequestParam("upload") MultipartFile upload,
			@RequestParam String myid,
			HttpServletRequest request
			){
		//���ε� �� ��� ���ϱ�
		String uploadPath=request.getSession().getServletContext().getRealPath("/resources");
		System.out.println(uploadPath);
		//���ε�
		String photoname=upload.getOriginalFilename();
		try {
			upload.transferTo(new File(uploadPath+"/"+photoname));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//db���� ���� ����
		memberService.updatePhoto(myid, photoname);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("photoname", photoname);
		
		return map;
	}
	
	@GetMapping("/updateform")
	public String updateForm(
			@RequestParam String myid,
			Model model
			) {
		MemberDto dto = memberService.getOneMember(myid);
		model.addAttribute("dto",dto);
		return "member/updateform";
	}
	
	//���� �� -> �̸� �ڵ��� �̸��� �ּ� ������� �� 
	
	//���� �� ������ �������� �̵�
	@PostMapping("/update")
	public String updateMember(
			@ModelAttribute MemberDto dto,
			@RequestParam String myid
			) {
		memberService.updateMember(dto);
		return "redirect:./detail?myid="+myid;
	}
	
	@ResponseBody
	@GetMapping("/deletepasswd")
	public Map<String, String> deletePasswd(
			@RequestParam int num,
			@RequestParam String passwd			
			){
		Map<String, String> map = new HashMap<String, String>();
		//����� ���� ��� data ����
		boolean b = memberService.equalPassCheck(passwd, num);
		if(b) {
			memberService.deleteMember(num);
		}
		map.put("status", b?"success":"fail");
		return map;
	}
	
}
