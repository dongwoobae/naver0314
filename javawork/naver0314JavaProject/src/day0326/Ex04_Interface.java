package day0326;
//인터페이스는 음식점의 메뉴판과 같다
//구현 가능한 목록을 나열만 하고 실체(body)가 없기 때문이다
//상수와 추상 메소드로만 구성이 되어있다.
interface InterA
{
	int MAX = 10;//상수이지만 구분할 필요가 없으므로 final 생략함
	public void disp();//추상메소드지만 구분할 필요가 없으므로 abstract 생략함
	public void study();
}

class MyInter implements InterA
{
//인터페이스는 모든 메소드를 오버라이드 해줘야 에러가 안남.
	@Override
	public void disp() {
		// TODO Auto-generated method stub
		System.out.println("현재 최대 인원수는 "+MAX+"명입니다");
	}

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("우리는 인터페이스를 공부하고 있어요!!");
	}
	public void play()
	{
		System.out.println("게임을 합니다");
	}
}
public class Ex04_Interface {
	public static void main(String[] args) {
	InterA a = new MyInter();
	a.disp();
	a.study();
	//a.play();//호출안됨
	//play를 호출하고자 할 경우
	((MyInter)a).play();//서브클래스로 형변환 후 호출하면 된다
}
}
