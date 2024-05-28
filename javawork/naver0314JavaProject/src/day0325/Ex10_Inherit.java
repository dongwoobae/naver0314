package day0325;


//Ex09에서 만든 클래스들을 이용한 예제
//다형성 처리에 대한 예제 (다형성으로 호출하려면 무조건 override)
public class Ex10_Inherit {

	public static void showAnimal(Animal ani)
	{
		ani.writeAnimal();//이때 ani변수는 cat이 되기도 하고 dog가 되기도 함
		//누가 생성되어 넘어오느냐에 따라서
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		showAnimal(new Cat());
		showAnimal(new Dog());
	}

}
