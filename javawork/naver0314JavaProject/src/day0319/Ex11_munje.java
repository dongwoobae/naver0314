package day0319;

import java.util.Scanner;

public class Ex11_munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str1;
		System.out.println("문자열 입력");
		str1=sc.nextLine();
		
		int x=str1.length();
		int upper=0,lower=0,num=0;
		for(int i=0;i<x;i++)
		{
			char a = str1.charAt(i);
		
			if(a<='Z'&&a>='A')
			{
				upper++;
				
			}
			else if(a>='a'&&a<='z')
			{
				lower++;
			}
			else if(a>='0'&&a<='9')
			{
				num++;
			}
						
		}
		System.out.println("소문자 개수:"+lower);
		System.out.println("대문자 개수:"+upper);
		System.out.println("숫자 개수:"+num);
		
		
		
		
	}

}
