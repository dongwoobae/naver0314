package day0315;

import java.util.Scanner;

public class Ex9_munjae {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int money;
		System.out.println("돈이 얼마 있습니까?");
		money = sc.nextInt();
		
		System.out.println("만원: "+(money/10000)+"장");
		System.out.println("천원: "+(money%10000/1000)+"장");
		System.out.println("백원: "+(money%1000/100)+"개");
		System.out.println("십원: "+(money%100)/10+"개");
		System.out.println("일원: "+(money%10)+"개");
		
		
	}

}
