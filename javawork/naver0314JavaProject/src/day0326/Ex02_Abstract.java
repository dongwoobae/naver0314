package day0326;

abstract class AbsEx1
{
	abstract public void play();
}

abstract class AbsEx2 extends AbsEx1
{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("게임을 합니다");
	}
	abstract public void study();
}

class AbsEx3 extends AbsEx2
{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		super.play();
		System.out.println("야구 게임을 합니다");
	}
	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("공부를 합니다");
	}
}
public class Ex02_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		write(new AbsEx3());
	}
public static void write(AbsEx2 ab)
{
	ab.play();
	ab.study();
}
}
