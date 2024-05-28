package day0328;
/*
 * 자바에서의 함수형 프로그램인 람다 표현식은 인터페이스를 사용하는
 * 익명 내부 클래스의 또다른 표현식이다.
 * 단 인터페이스는 하나의 추상 메소드만 가지고 있어야한다.
 */

@FunctionalInterface // 메소드가 하나인지 아닌지 검증하는 역할, 오류발생
interface Orange
{
	public void write();//추상메소드
	//public void play();//추가하는 순간 오류발생 functionalInterface 때문에
}
@FunctionalInterface
interface DataAdd 
{
	public void add(int x, int y);
}

public class Ex02_Lambda {

		//우리가 알고있는 익명 내부클래스 형태로 Orange를 구현
	Orange or = new Orange() {
		
		@Override
		public void write() {
			// TODO Auto-generated method stub
			System.out.println("오렌지 먹고싶어요");
		}
	};
	public void lambdaMethod()
	{
		Orange or2 = ()->System.out.println("람다식 오렌지 먹고싶어요");
		or2.write();
		
		Orange or3=()->
			System.out.println("안녕하세요");
			System.out.println("람다식 공부중....");
		
			or3.write();
			
		Orange or4 = new Orange() {
			
			@Override
			public void write() {
				// TODO Auto-generated method stub
				System.out.println("다양한 방법으로 구현하기");
			}
		};
		or4.write();
		}
		
	public void lambdaMethod2()
	{
		DataAdd add1 = (int x,int y)->System.out.println("두수의 합: "+(x+y));
		add1.add(10, 20);
		add1.add(5, 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_Lambda ex = new Ex02_Lambda();
		ex.or.write();
		ex.lambdaMethod();
		ex.lambdaMethod2();
	}

}
