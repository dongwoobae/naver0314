package controller.comment;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import data.dto.CommentDto;
import data.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/insert")
	public String insertComment(CommentDto dto,
			@RequestParam int mynum) {
		commentService.insertComment(dto);
		 return "redirect:/member/detail?num="+mynum;
	}
	@ResponseBody
	@PostMapping("/delete")
	public Map<String, String> deleteComment(int num,String passwd) {
		 int check=commentService.deleteComment(passwd, num);
		 Map<String, String> map = new HashMap<>();
		 if(check==1) {
			 map.put("status", "success");
		 }
		 else {
			 map.put("status", "fail");
		 }
		 return map;
	}
	
}
