package day0319;

import java.util.Arrays;
import java.util.Scanner;

public class Factorial {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a;
		long sum=1;
		
		System.out.println("팩토리얼 숫자를 쓰시오");
		a = sc.nextInt();
		if(a>10||a<=0) {
			System.out.println("1~10 사이의 숫자를 쓰시오");
			return;
		}
		else {
			
		
		for(int i=1;i<=a;i++)
		{
			sum*=i;
			
		}
		
		System.out.printf("%d! = %s\n",a,sum);
		
		
			
		}
	}	
}

