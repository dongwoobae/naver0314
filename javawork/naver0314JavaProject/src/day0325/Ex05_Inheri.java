package day0325;

class Parent1
{
	void method1()
	{
		System.out.println("부모의 디폴트 메소드");
	}
	protected void method2()
	{
		System.out.println("부모의 protected 메소드");
	}
	private void method3()
	{
		System.out.println("부모의 private 메소드");
	}
	public void method4()
	{
		System.out.println("부모의 public 메소드");
	}
}
class Sub1 extends Parent1
{
	public void show()
	{
		this.method1();//default <- 부모가 다른 패키지에 있다면 default도 호출안됨
		this.method2();//protected
		//this.method3(); private은 상속이 안됨
		this.method4();//public
		System.out.println("super로 호출");
		super.method1();
		super.method2();
		super.method4();//this로도 가능하고 super로도 가능
		//다만 현재 class에 같은 이름의 메소드가 존재할 경우에는 this말고 super로 호출해야함
		//같은 이름의 메소드를 override 메소드라고한다.
	}
}
public class Ex05_Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub1 s = new Sub1();
		s.show();
	}

}
