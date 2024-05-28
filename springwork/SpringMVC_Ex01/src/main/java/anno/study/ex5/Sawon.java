package anno.study.ex5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import lombok.Getter;

@Component
@Getter
public class Sawon {
	@Value("공혁준")
	private String name;
	@Value("서울시 송파구")
	private String addr;
	@Value("34")
	private int age;
}
