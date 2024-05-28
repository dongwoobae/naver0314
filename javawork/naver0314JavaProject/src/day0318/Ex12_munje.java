package day0318;

import java.util.Scanner;

public class Ex12_munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		/*
		 * 구구단
		 * 11을 누르면 잘못된 숫자입니다.
		 * 
		 */
		int x;
		System.out.println("몇단을 보시겠습니까?");
		x = sc.nextInt();
		
		
		if (x>=10||x<=1)
		{
			System.out.println("잘못된 숫자입니다.");
			return;
		}
		else 
		{
			System.out.printf("** %s단 **\n",x);
		}
		
		
		for(int i=1;i<=9;i++)
		{
			int gob = i * x;
			
			System.out.printf("%s x %s = %s\n",x,i,gob);
		}
		
		
		
		
		
		
	}

}
