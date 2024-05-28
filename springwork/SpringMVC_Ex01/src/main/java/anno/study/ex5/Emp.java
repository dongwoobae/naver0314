package anno.study.ex5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
//@RequiredArgsConstructor
public class Emp {
	//사원의 값을 가져오기 위해 Sawon만 받는 생성자를 만들어준다.
//	@NonNull 
	@Autowired// 생성자를 만들고 자동 주입을 해준다.
	private Sawon sawon;
	@Value("삼성")
	private String empName;
	@Value("2020-05-14")
	private String ipsaday;
	
	public void sawonInfo() {
		System.out.println("*** 사원 정보 ***");
		System.out.println("입사일: "+ipsaday);
		System.out.println("회사명: "+empName);
		System.out.println("사원명: "+sawon.getName());
		System.out.println("주소: "+sawon.getAddr());
		System.out.println("나이: "+sawon.getAge());
	}
}
