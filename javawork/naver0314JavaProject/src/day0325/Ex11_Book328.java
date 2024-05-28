package day0325;

abstract class Animale
{
	public void breathe()
	{
		System.out.println("숨을 쉽니다");
	}
	public abstract void sound();
}

class Doge extends Animale
{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
	System.out.println("멍멍");	
	}
}

class Cate extends Animale
{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
	System.out.println("야옹");	
	}
}

public class Ex11_Book328 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Doge dog = new Doge();
		dog.sound();
		
		Cate cat = new Cate();
		cat.sound();
		
		animalSound(new Doge());
		animalSound(new Cate());
		
	}

	public static void animalSound(Animale animal)
	{
		animal.sound();
	}
}
