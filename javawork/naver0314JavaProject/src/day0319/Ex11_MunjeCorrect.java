package day0319;

import java.util.Scanner;

public class Ex11_MunjeCorrect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String msg;
		int upperAlpha=0,lowerAlpha=0,num=0;
		System.out.println("문장을 입력해주세요");
		msg = sc.nextLine();
		
		for(int i=0;i<msg.length();i++)
			{
			char ch = msg.charAt(i);
			
		
			if(ch>='a'&&ch<='z')
				{
				lowerAlpha++;
				}
			else if(ch>='A'&&ch<='Z')
			{
				upperAlpha++;
			}
			else if(ch>='0'&&ch<='9')
			{
				num++;
			}
			}
		
			System.out.println("소문자: "+lowerAlpha);
			System.out.println("대문자: "+upperAlpha);
			System.out.println("숫자: "+num);
			
			
		
		
		
	}

}
