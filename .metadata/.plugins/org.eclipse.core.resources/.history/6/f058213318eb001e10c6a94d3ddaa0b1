package day0326;

interface Apple
{
	public void one();
}
//interface끼리의 상속은 extends
interface Banana extends Apple
{
	public void two();
}

class Orange implements Banana
{
	@Override
	public void one() {
		// TODO Auto-generated method stub
		System.out.println("하나");
	}
	@Override
	public void two() {
		// TODO Auto-generated method stub
		System.out.println("둘");
	}
	public void three()
	{
		System.out.println("셋");
	}
}
public class Ex05_Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Banana b =new Orange();
		b.one();
		b.two();
		((Orange)b).three();
	}

}
