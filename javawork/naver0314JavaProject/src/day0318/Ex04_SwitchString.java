package day0318;

import java.util.Scanner;

public class Ex04_SwitchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String color;
		System.out.println("영문으로 색상 입력하기");
		color=sc.nextLine();
		//switch에서 문자열도 가능 (JDK8부터)
		
		switch (color) {
		case "red"://break를 만나는 케이스로 실행이됨, case 나열은 수직 수평 무관
		case "RED":
		case "Red":
			System.out.println("빨강색");
			break;
		
		case "GREEN":
		case "Green":
		case "green":
			System.out.println("초록색");
			break;
			
		case "PINK":
		case "Pink":
		case "pink":
			System.out.println("분홍색");
			break;
			
		default:
			System.out.println("빨강,초록,핑크 이외의 색!");
			
		}
		//string에서 전부 소문자로 인식되게 하는 명령어를 사용하여 위처럼 케이스 나열을 안해도 되게 할 수 있음.
		
		
		
		
	}

}
