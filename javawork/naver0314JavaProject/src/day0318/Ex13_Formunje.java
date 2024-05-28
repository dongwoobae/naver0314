package day0318;

import java.util.Scanner;

public class Ex13_Formunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("지수승 구하기");
		System.out.println("3의 3승 "+(int)Math.pow(3, 3));
		System.out.println("2의 4승 "+(int)Math.pow(2, 4));

		Scanner sc=new Scanner(System.in);
		int x,y,sum=1;
		System.out.println("x를 입력하시오");
		x=sc.nextInt();
		
		System.out.println("y를 입력하시오");
		y=sc.nextInt();
		
		for(int i=1;i<=y;i++)
		{
			sum*=x;
		}
		System.out.printf("%d의 %d승은 %d입니다",x,y,sum);//이게 for문 안에 있으면 이 print 명령어도 반복이 되어서 y번 출력됨
		
		
	}

}
