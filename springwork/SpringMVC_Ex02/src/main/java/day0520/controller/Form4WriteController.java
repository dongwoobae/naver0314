package day0520.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form4WriteController {
	@PostMapping("/read4")
	public String read4(
			//Form 태그의 name이 key값으로, 입력되거나 선택된 값이 value값으로 들어옴
			@RequestParam Map<String, String> map,
			Model model
			) {
		model.addAttribute("fname",map.get("foodname"));
		model.addAttribute("fphoto",map.get("foodphoto"));
		model.addAttribute("fprice",map.get("price"));
		model.addAttribute("fcnt",map.get("cnt"));

		return "form4/result4";
	}
}
