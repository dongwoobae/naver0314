package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.dto.CommentDto;
import member.service.CommentService;

@Controller
@RequestMapping("/comment")
public class commentListController {
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/insert")
	public String insertComment(
			@ModelAttribute CommentDto dto,
			@RequestParam String myid
			) {
		commentService.insertComment(dto);
		return "redirect:./member/detail?myid="+myid;
	}
}
