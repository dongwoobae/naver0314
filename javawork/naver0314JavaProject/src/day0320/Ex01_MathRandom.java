package day0320;

import java.util.Random;

public class Ex01_MathRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*** Math.Random()을 이용한 난수 구하기 ***");
		
		/*for(int i=1;i<=5;i++)
		{
			double d=Math.random();//5개의 0보다 크고 1보다 작은 난수 발생
			System.out.printf("%2s",d);
		}System.out.println();
		*///더러워서 지워놓음
		for(int i=1;i<=5;i++)
		{
			double d=Math.random();
			int a = (int) (d*10);//0부터 9 난수 발생
			System.out.printf("%2d",a);
		}System.out.println();
		
		for(int i=1;i<=5;i++)
		{
			double d=Math.random();
			int a = (int) (d*100+1);//1부터 100 난수 발생
			System.out.printf("%3d",a);
		}System.out.println();
		
		for(int i=1;i<=5;i++)
		{
			double d=Math.random();
			int a = (int) (d*26+65);//대문자 아스키 코드가 65~90
			char b = (char)(a);//int형태의 a를 char로 변형
			System.out.printf("%2s",b);
		}System.out.println();
		
		for(int i=1;i<=5;i++)
		{
			double d=Math.random();
			int a = (int) (d*26+97);//소문자 아스키 코드가 97~122
			char b = (char)(a);//int형태의 a를 char로 변형
			System.out.printf("%2s",b);
		}
		
		
	}

}
