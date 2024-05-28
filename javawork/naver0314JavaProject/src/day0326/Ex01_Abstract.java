package day0326;

abstract class Animal//abstract 메소드는 오버라이드만을 목적으로 body({}) 없이 구현하고자 할 경우
//앞에 abstract를 붙여서 추상 메소드로 만든다.
//abstract 메소드를 한개 이상 포함하고 있는 클래스는 클래스 역시 abstract화 해야 한다.
//단, 추상 클래스는 그 자체로는 생성 할수 없다. new로 생성을 말함
//추상 클래스를 상속받는 서브 클래스는 반드시 추상 메소드를 오버라이드 해야만 하는데
//만약 오버라이드 하지 않았을 경우 서브클래스 역시 추상화 시킨다.
{
//	public void sound ()
//	{
//		System.out.println("딱히 하는 일이 없음");
//	}
	abstract public void sound();
	//추상클래스에는 추상 메소드 뿐 아니라 일반 메소드도 포함 가능
	public void showTitle()
	{
		System.out.println("추상 클래스 공부중!");
	}
}

class Dog extends Animal
{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
}

class Cat extends Animal
{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		
		System.out.println("야옹야옹");
	}
}

class Chick extends Animal
{
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		//super.sound();
		System.out.println("삐약삐약");
		showTitle();
	}
}

public class Ex01_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		animalSound(new Cat());
		animalSound(new Dog());
		animalSound(new Chick());
		//animalSound(new Animal()); 이렇게 new로 생성 불가
		
		
		
	}
public static void animalSound(Animal ani)
{
	ani.showTitle();
	ani.sound();
	System.out.println();
}
}
