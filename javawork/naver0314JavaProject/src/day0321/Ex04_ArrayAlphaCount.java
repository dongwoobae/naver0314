package day0321;

import java.util.Scanner;

public class Ex04_ArrayAlphaCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 영어문장을 입력하면 알파벳 기준으로 각각의 개수를 출력하시오
		 * Have a nice day
		 * a:3개 b:0개....z:0개
		 */
		
		Scanner sc = new Scanner(System.in);
		String msg;
		int[]alpha = new int [26];
		System.out.println("영문장을 쓰시오");
		msg =sc.nextLine();
		
		for(int i=0;i<msg.length();i++)
		{
			char a = msg.toUpperCase().charAt(i);
			int num = a-'A';
			if(a>='A'&&a<='Z')
			alpha[num]++;
			
				
		}
		System.out.println("*** 알파벳별 개수 구하기 ***");
	
		for(int i=0;i<alpha.length;i++)
	{
			
		System.out.printf("%c: %d\t",(char)('A'+i),alpha[i]);
		if((i+1)%5==0)
			System.out.println();
	}
	}
	
	
}
