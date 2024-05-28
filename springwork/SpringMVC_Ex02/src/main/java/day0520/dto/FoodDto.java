package day0520.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FoodDto {
	//폼태그의 name과 변수명이 반드시 같아야 한다. 아니면 자동으로 못읽어옴.
	private String foodname;
	private String foodphoto;
	private int price;
	private int cnt;
	
}
