package day0319;

public class Ex06_While {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		while (n>10)
		{
			System.out.println("hello #1");
		}//선조건 : 조건이 맞지않으면 바로 반복문을 빠져나감
		System.out.println();
		do {
			System.out.println("Hello #2");
		} while (n>10);
		//후조건 일단 do에 적힌것을 수행 후 조건이 맞지않으면 빠져나간다. 조건이 맞으면 무한 수행
		
		int a=1;
		while(a<=10)
		{
			System.out.printf("%3d",a++);
		}
		System.out.println();
		a=1;
		while(true)
		{
			System.out.printf("%3d",a++);
			if (a>10)
				break;
		}System.out.println();
		
		char ch ='A';
		
		while(true)
		{
			
				System.out.printf("%2s",ch++);
			if(ch>'Z')
				break;
		}
		
		
		
		
		
		
	}

		
}
