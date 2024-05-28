package study.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex03_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("appex3.xml");

		MyCart mC = (MyCart)context.getBean("cart");

//		mC.show();

		MyCart mC2 = (MyCart)context.getBean("cart");

//		mC2.show();
		
		System.out.println("singleton 인 경우는 여러번 생성해도 주소가 같고");
		System.out.println("prototype인 경우에는 새로 생성할때마다 새로운 주소에 생성된다");
		
		System.out.println(mC.hashCode());
		System.out.println(mC2.hashCode());
		//scope="singleton" 일때는 주소가 동일
		//scope="prototype" 일때는 주소가 다름
	}

}
