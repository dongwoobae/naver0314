package study.ex3;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
public class MyCart {
	Person person;
	@NonNull
	private String sangpum;	
	@NonNull
	private int price;
	
//	public MyCart(String sangpum, int price) {
//		// TODO Auto-generated constructor stub
//		this.sangpum=sangpum;
//		this.price=price;
//	}
//	
//	public void setPerson(Person person) {
//		this.person=person;
//	}
	
	public void show() {
		System.out.println("쇼핑한 사람 이름: "+person.getName()+"\n핸드폰번호: "+person.getPhone());
		System.out.println("상품명: "+sangpum);
		System.out.println("상품 가격: "+price);
	}
}
