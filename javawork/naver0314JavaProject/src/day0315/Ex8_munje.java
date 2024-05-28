package day0315;

import java.util.Scanner;

public class Ex8_munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int  birthYear, age;
		String name, hp;
		System.out.println("이름은?");
		name = sc.nextLine();
		
		System.out.println("전화번호는?");
		hp = sc.nextLine();
		
		System.out.println("태어난 연도는?");
		birthYear = Integer.parseInt(sc.nextLine());
		age = 2024- birthYear;
		
		//System.out.printf("이름: " +name);
		System.out.println("\n이름: "+name+"");

		//System.out.printf("\n핸드폰: " +hp);
		System.out.println("\n핸드폰: "+hp+"");
		
		//System.out.printf("\n태어난 연도: " +birthYear);
		System.out.println("\n태어난 연도: "+birthYear+"");
		
		//System.out.printf("\n나이: "+(2024-birthYear));
		System.out.println("\n나이:"+age+"");
	}

}
