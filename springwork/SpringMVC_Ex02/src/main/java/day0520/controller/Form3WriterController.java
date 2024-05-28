package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import day0520.dto.FoodDto;

@Controller
public class Form3WriterController {
	@PostMapping("/read3")
	public String read3(
			//폼태크에서 같은 이름을 자동으로 읽어온다.
			//이 자체가 모델이어서 따로 저장해줄 필요도 없다.
			//Model에 foodDto 라는 이름으로 저장이 된다.			
			//@ModelAttribute FoodDto dto //Dto 클래스명을 바꾸고 싶을 경우
			//FoodDto dto //얘도 기본이름을 그냥 쓸 시 @ModelAttribute 생략 가능하다.
			@ModelAttribute("fdto") FoodDto dto
			) {
		return "form3/result3";
	}
}
