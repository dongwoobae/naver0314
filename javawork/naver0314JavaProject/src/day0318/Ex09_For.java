package day0318;

import java.util.Iterator;

public class Ex09_For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;++i)
			System.out.printf("%4d",i);
		System.out.println();//이거 없으면 바로 뒤에 다음 값이 붙어나옴
		
		for(int i=10;i>=1;i--)
			System.out.printf("%4d",i);
		System.out.println();
		
		for(int i=0;i<=10;i+=3)
			System.out.printf("%4d",i);
		System.out.println();
		
		for(int i='A';i<='Z';i++)
			System.out.printf("%2c",(char)i);
		System.out.println();
		
		for(int i=65;i<=90;i++)
			System.out.printf("%2c",(char)i);
		System.out.println();
		
		for(int i=97;i<=122;i++)
			System.out.printf("%2c",(char)i);//char 이면 아스키코드로 출력됨
		System.out.println();
		
		for(int i=1;i<=10;i++)
		{System.out.printf("%3d",i);
		if(i==5)
			break;//현재 속한 반복문을 빠져나간다
		
		}
		System.out.println();
		
		for (int i=1;i<=10;i++)
		{
			if(i%2==0)
				continue;//짝수일 경우는 출력하지말고 i++로 가라
			System.out.printf("%3d",i);
		}
		
		
		
		
		
		
	}

}
