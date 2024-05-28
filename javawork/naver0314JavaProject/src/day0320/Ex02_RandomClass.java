package day0320;

import java.util.Random;

public class Ex02_RandomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		System.out.println("*** Random Class를 이용한 난수 구하기 ***");

		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(10);//0~9의 난수 추출
			System.out.printf("%4d",n);
		}System.out.println();
		
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(10)+1;//1~10의 난수 추출
			System.out.printf("%4d",n);
		}System.out.println();
		
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(100)+1;//1~100의 난수 추출
			System.out.printf("%4d",n);
		}System.out.println();

		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(26)+65;//65~90의 난수 추출
			char a = (char)(n);//int를 char로 변형
			System.out.printf("%4s",a);//%d는 정수형태라 문자열 %s로 바꿔줘야함
		}System.out.println();
	
	for(int i=1;i<=5;i++)
	{
		int n=r.nextInt(26)+97;//97~122의 난수 추출
		char a =(char)(n);
		System.out.printf("%4s",a);
	}System.out.println();

}
	
}
