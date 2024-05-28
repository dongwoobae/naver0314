package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form1WriteController {
	@GetMapping("/read1")
	public String read1(
			//@RequestParam("name") String name,
			//@RequestParam String name,//생략하는게 아예 생략이 아니라 이렇게
			String name,//@RequestParam도 생략 가능
			@RequestParam("addr") String a,
			@RequestParam("age") int myage,
			//form tag에 지정한 이름과 변수명이 같게 설정하는 것은 기본값이라 생략가능
			//하지만 나중에 생략이 안되는 경우도 있기에 생략안하는 것이 좋음
			Model model
			) {
		model.addAttribute("name", name);
		model.addAttribute("addr", a);
		model.addAttribute("info", myage>=20?"성인":"미성년자");
		model.addAttribute("age", myage);
		
		return "form1/result1";
	}
	
}
