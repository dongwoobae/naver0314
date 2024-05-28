package day0327;

import java.util.List;
import java.util.Stack;

public class Ex05_Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List 인터페이스를 구현한 클래스 중 하나
		//Last in First Out (LIFO)방식 : 먼저 들어간게 나중에 나오는 방식
		Stack<String> stack1 = new Stack<String>();
		//List<String> stack1 = new Stack<String>();
		//push 는 오버라이드 메소드가 아니라 stack 만 가지고 있는 메소드
		stack1.push("사과");
		stack1.push("오렌지");
		stack1.push("사과");
		stack1.push("딸기");
		stack1.push("포도");
		
		System.out.println("총 개수: "+stack1.size());
		while(!stack1.isEmpty())//empty가 아닐동안
		{
			System.out.println(stack1.pop());//마지막으로 추가한 포도가 먼저 출력됨
		}
	}

}
