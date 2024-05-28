package day0520.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import day0520.dto.FoodDto;

@Controller
public class Form3WriterController {
	@PostMapping("/read3")
	public String read3(
			//����ũ���� ���� �̸��� �ڵ����� �о�´�.
			//�� ��ü�� ���̾ ���� �������� �ʿ䵵 ����.
			//Model�� foodDto ��� �̸����� ������ �ȴ�.			
			//@ModelAttribute FoodDto dto //Dto Ŭ�������� �ٲٰ� ���� ���
			//FoodDto dto //�굵 �⺻�̸��� �׳� �� �� @ModelAttribute ���� �����ϴ�.
			@ModelAttribute("fdto") FoodDto dto
			) {
		return "form3/result3";
	}
}
