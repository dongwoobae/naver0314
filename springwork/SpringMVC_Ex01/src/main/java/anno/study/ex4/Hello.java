package anno.study.ex4;

import org.springframework.stereotype.Component;

import lombok.Data;


//@Component //xml에 자동 등록, 이 경우 클래스이름이 곧 아이디가 된다.
@Component("h")// 아이디가 h로 등록
@Data
public class Hello {
	private int num;
	private String name;
	
	public void showMessage() {
		System.out.println("Hello Class가 가진 메소드입니다");
	}
	
	
}
