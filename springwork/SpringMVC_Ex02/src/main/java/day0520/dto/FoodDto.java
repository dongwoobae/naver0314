package day0520.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FoodDto {
	//���±��� name�� �������� �ݵ�� ���ƾ� �Ѵ�. �ƴϸ� �ڵ����� ���о��.
	private String foodname;
	private String foodphoto;
	private int price;
	private int cnt;
	
}
