package day0318;

import java.util.Scanner;

public class Ex08_munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String sang;
		int su,dan,total,dctotal;
		//double dctotal;
		
		System.out.println("상품명은?");
		sang = sc.nextLine();
		
		System.out.println("상품 수량은?");
		su = sc.nextInt();
		
		System.out.println("단가는?");
		dan = sc.nextInt();
		
		total = su * dan;
		//dctotal	= total * 90/100;
		dctotal = (int)(total * 0.9);
		
				
		if (su>=5) {
			System.out.println(sang+su+"개의 총 금액:"+total+"원");
			System.out.println("10프로 할인입니다.");
			System.out.println("10프로 할인된 금액: "+dctotal+"원");
		}
		else {
			//System.out.println(sang+" "+su+"개의 총 금액:"+total+"원");
			System.out.printf("%s %d개의 총 금액: %d\n",sang,su,total);//\n안넣으면 뒤에 출력되는게 바로 뒤에 붙음
		}
				
	
	
	}

}
