package day0326;

class OuterClass
{
	int a=10;
	static int b =20;
	
	class InnerClass
	{
		int c=30;
		static int d=40;//JDK11버전에서는 오류, 멤버 내부클래스에서는 static 변수 선언 불가였는데
		//JDK 17부터 가능하게 변경됨
		
		public void show()
		{
			System.out.println("a="+a);
			System.out.println("b="+b);
			System.out.println("c="+c);
			System.out.println("d="+d);
		}
	}
	//정적 내부 클래스
	static class InnerClass2
	{
		int e=30;
		static int f=60;
		public void shoow()
		{
		//	System.out.println("a="+a);// 외부 클래스의 인스턴스 변수는 접근 불가
			System.out.println("b="+b);
			System.out.println("e="+e);
			System.out.println("f="+f);
		}
	}
	public void disp()
	{
		//내부 클래스가 가진 show 메소드 호출
		InnerClass in = new InnerClass();
		in.show();
	}
}
public class Ex09_InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OuterClass o = new OuterClass();
		o.disp();
	}

}
