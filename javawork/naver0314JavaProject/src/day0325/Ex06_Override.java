package day0325;

class Parent2
{
	public void job()
	{
		System.out.println("부모 클래스에서 해야할 일 처리...");
	}
}
class Sub2 extends Parent2
{
	@Override
	public void job() {
		// TODO Auto-generated method stub
		super.job();//같은 이름의 메소드가 현 클래스에 존재하므로 부모가 가진 메소드 호출시 반드시 super로 호출해야한다.
		System.out.println("자식 클래스에서 처리해야할 일..");
	}//부모 클래스에서 하고 자식클래스에서 마저 처리해야할때 쓰는게 override
}
public class Ex06_Override {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Sub2 s =new Sub2();
		s.job();//sub2가 가진 job method가 호출
	}

}
