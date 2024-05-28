package day0318;

import java.util.Scanner;

public class Ex1_munje {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int score;
		String msg;
		
		System.out.println("점수?");
		
		score = sc.nextInt();
		//if문을 이용해서 점수를 잘못입력했을 경우 메서드 종료를 하자
		if (score<1 || score>100) {
			System.out.println("잘못된 점수입니다");
			return; //main 메서드를 종료=> 프로그램이 종료
		}
		
		msg = score>=90?"A"
					:score>=80?"B"
							:score>=70?"C"
									:score>=60?"D"
											:"F";
		System.out.println(score+"\n");	
		
		System.out.println(score+"점은 "+msg+"학점입니다");
												
		
		
		
		
		
	}
}
