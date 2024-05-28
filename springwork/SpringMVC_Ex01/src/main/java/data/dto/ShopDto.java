package data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor //default 생성자
@AllArgsConstructor //모든 멤버 변수를 인자로 받는 생성자
//@Setter
//@Getter
//@ToString
@Data //setter + getter + toString 합친거
public class ShopDto {
	private String sangpoom;
	private String photo;
	private int price;
	private int su;
	
}
