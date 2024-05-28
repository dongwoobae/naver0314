package anno.study.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//public class Car {
//	private String carName;
//	private Tire tire;
//	
//	public Car(Tire tire) {
//		this.tire=tire;
//	}
//	
//	public void setCarName(String carName) {
//		this.carName = carName;
//	}
//	
//	public void carInfo() {
//		System.out.println("자동차명: "+carName);
//		System.out.println("타이어: "+tire.getTireName());
//	}
//}
//annotation으로 수정
//@Component //xml에 car로 등록
//public class Car {
//	@Value("Audi A7")
//	private String carName;
////	@Autowired //자동으로 찾아서 주입시켜줌. 
//	//근데 이번에는 interface를 상속받는 애가 두명이어서 오류가 남.
////	private Tire tire;
//	@Autowired
//	private KoreaTire tire; //정확하게 class명으로 선언해야 오류 X.
////	public Car(Tire tire) {
////		this.tire=tire;
////	} KoreaTire로 정해졌으므로 더이상 어떤타이어인지 고르는 메소드는 필요없음
//	
//	public void setCarName(String carName) {
//		this.carName = carName;
//	}
//	
//	public void carInfo() {
//		System.out.println("자동차명: "+carName);
//		System.out.println("타이어: "+tire.getTireName());
//	}
//}
@Component
@RequiredArgsConstructor
public class Car {
	@Value("BMW 530i")
	private String carName;
	@NonNull
	private CanadaTire tire;
	
	public void carInfo() {
		System.out.println("자동차명: "+carName);
		System.out.println("타이어: "+tire.getTireName());
	}
}