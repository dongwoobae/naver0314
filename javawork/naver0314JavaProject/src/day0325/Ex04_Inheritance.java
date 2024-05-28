package day0325;

class AA{
	AA()
	{
		System.out.println("AA의 디폴트 생성자");
	}
	AA(String msg)
	{
		System.out.println(msg+"문자열을 받는 생성자");
		System.out.println(msg+"를 받는 생성자 ㅍㅍ");
	}
}
class BB extends AA
{
	BB()
	{
		//super();가 생략되있음.부모의 디폴트 생성자를 호출
		System.out.println("BB의 디폴트 생성자");
	}
}
public class Ex04_Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BB b =new BB();
		
		
			
	}
	

}
