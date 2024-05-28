package controller.member;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/member")
public class MemberFormController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/form")
	public String form() {
		return "member/memberform";
	}
	
	@ResponseBody //json으로 반환
	@GetMapping("/idcheck")
	public Map<String, Integer> getMethodName(@RequestParam String searchid) {
		Map<String, Integer> map = new HashMap<>();
		
		int count=memberService.getIdCheck(searchid);
		
		map.put("count", count);
		
		return map;
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute MemberDto dto,
			@RequestParam("myfile") MultipartFile myfile,
			javax.servlet.http.HttpServletRequest request
			) {
		      //업로드 될 경로
		String savePath=request.getSession().getServletContext().getRealPath("/save");
		//업로드한 파일의 확장자 분리
		String ext=myfile.getOriginalFilename().split("\\.")[1];
		String photo=UUID.randomUUID()+"."+ext;
		dto.setPhoto(photo);
		try {
			myfile.transferTo(new File(savePath+"/"+photo));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		memberService.insertMember(dto);
		
	    return "redirect:./list";
	}
	
}
