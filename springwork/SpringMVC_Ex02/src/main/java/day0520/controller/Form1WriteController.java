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
			//@RequestParam String name,//�����ϴ°� �ƿ� ������ �ƴ϶� �̷���
			String name,//@RequestParam�� ���� ����
			@RequestParam("addr") String a,
			@RequestParam("age") int myage,
			//form tag�� ������ �̸��� �������� ���� �����ϴ� ���� �⺻���̶� ��������
			//������ ���߿� ������ �ȵǴ� ��쵵 �ֱ⿡ �������ϴ� ���� ����
			Model model
			) {
		model.addAttribute("name", name);
		model.addAttribute("addr", a);
		model.addAttribute("info", myage>=20?"����":"�̼�����");
		model.addAttribute("age", myage);
		
		return "form1/result1";
	}
	
}
