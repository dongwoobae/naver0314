package study.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("기존의 자바 방식으로 호출 #1");
		MessageInter m = null;
		
		m=new Message1();
		String s=m.sayHello("이영자");
		System.out.println(s);
		
		m=new Message2();
		s=m.sayHello("강호동");
		System.out.println(s);
		
		System.out.println("\n스프링 방식으로 호출 #1");
		ApplicationContext context = new ClassPathXmlApplicationContext("appex1.xml");
		MessageInter mi = (Message1)context.getBean("mes1");//반환타입이 오브젝트라 형변환 해야함
		s=mi.sayHello("캔디");
		System.out.println(s);
		
		mi=context.getBean("mes2", Message2.class);
		s=mi.sayHello("마이크");
		System.out.println(s);
	}

}
