package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Form2WriteController {
	@PostMapping("/read2")
	public String read2(
			//form tag의 name과 같은 변수로 읽어올 경우 @RequestParam 생략
			String name,
			String addr,
			int age,
			Model model
			) {
		//post 방식은 한글이 깨져서 인코딩을 넣어줘야함.
		//여기에 인코딩 넣어도 읽어올때 깨지기 때문에 소용없.
		//web.xml 자체에 넣어야됨
		model.addAttribute("name", name);
		model.addAttribute("addr", addr);
		model.addAttribute("age", age);

		return "form2/result2";
	}
}
