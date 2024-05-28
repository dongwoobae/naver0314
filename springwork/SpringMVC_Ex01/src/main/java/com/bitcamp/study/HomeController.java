package com.bitcamp.study;

import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import data.dto.ShopDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		ShopDto dto1= new ShopDto();
//		dto1.setSangpoom("머리띠");
//		dto1.setPhoto("shop/30.jpg");
//		dto1.setPrice(13000);
//		dto1.setSu(3);
//		
//		ShopDto dto2 = new ShopDto("머리끈","shop/26.jpg",9000,5);
//		
//		model.addAttribute("dto1",dto1);
//		model.addAttribute("dto2",dto2);
//		
////		System.out.println(dto1.toString());//위와 아래가 같은 뜻
////		System.out.println(dto2);//toString 생략가능
//		
//		model.addAttribute("msg","Hello SpringFramework!");
//		model.addAttribute("today",new Date());
//		return "home";//포워드
//	}
	
	//RequestMapping 은 method get, post 지정해줘야한다.
	//@GetMapping, @PostMapping 이 스프링버전 5부터 추가됨
	@GetMapping("/")//mapping을 메소드 별로 붙일 수 있어서 한 파일안에 여러 맵핑의 메소드를 만들 수 있음
	public String startSpringWeb(Model model) {
			
		
		return "start";
	}
	
	@GetMapping("/board/list")//list.do도 list로 호출됨 
	//(/board/list.do)로 맵핑했을 경우에는 /board/list 는 찾을 수 없음이 뜸
	public String Hello(Model model) {
		//모델을 parameter로 받고 return은 해당 jsp 이름으로
		model.addAttribute("msg","안녕하세요");
		//addAttribute로 값 넣어줌
		return "result1";
	}
	
	@GetMapping("/guest/list")
	public ModelAndView Hello2() {
		//클래스 자체가 모델이고 setViewName으로 jsp 파일 이름을 지정
		ModelAndView mv=new ModelAndView();
		mv.addObject("today",new Date());
		//addObject 함수로 값 넣어줌
		mv.setViewName("result2");
		return mv;
	}
}
