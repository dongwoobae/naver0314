package day0318;

import java.util.Scanner;

public class Ex07_munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String name;
		int gibon,familysu,totpay;
		
		System.out.println("이름을 적으십시오.");
		name = sc.nextLine();
		
		System.out.println("기본급을 적으십시오.");
		gibon = sc.nextInt();
		
		System.out.println("가족인원수를 적으십시오.");
		familysu = sc.nextInt();
		
		System.out.println("이름은 "+name+"입니다.");
		System.out.println("기본급은 "+gibon+"원입니다.");
		System.out.println("가족수는 "+familysu+"명입니다.");
		/*switch (familysu) {
		case 3:
		case 4:
		case 5:
		case 6:
			totpay = gibon + (familysu*50000)
			break;
		
		case 1:
		case 2:
			totpay = gibon + 30000	
			}
		*/
		
		if (familysu>=3){
			totpay = gibon + (familysu*50000);
		}
		else {
			totpay = gibon + 30000;
		}
		
		System.out.println("실수령액은 "+totpay+"원입니다.");
		
		
		
		
		
		
	}

}
