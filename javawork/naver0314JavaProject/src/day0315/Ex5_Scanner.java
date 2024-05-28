package day0315;

import java.util.Scanner;

public class Ex5_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner 선언
		Scanner sc = new Scanner (System.in);//키보드로부터 입력을 받는 인스턴스 변수
		String msg = "";
		System.out.println("메세지를 입력하세요");
		msg = sc.nextLine();//next는 한단어만 nextline은 한문장 전체(문자열로)
		System.out.println("입력한 문자열은 \""+msg+"\"입니다");//따옴표 출력시키고 싶으면 \"
		System.out.println("입력한 문자열은 \'"+msg+"\'입니다");
		
		int age;
		System.out.println("당신의 나이는?");
		//age = sc.nextInt();
		
		age = Integer.parseInt(sc.nextLine());
		System.out.println("제 나이는 "+age+"세입니다.");
		
		
	
	
	}

}
