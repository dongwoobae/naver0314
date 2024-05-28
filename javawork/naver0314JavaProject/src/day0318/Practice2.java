package day0318;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		String name;
		int num,price,total,dtotal;
		
		
		System.out.println("상품명을 입력하시오");
		name = sc.nextLine();
		
		System.out.println("상품 수량은?");
		num = sc.nextInt();
		
		System.out.println("상품 단가는?");
		price = sc.nextInt();
		
		total = num * price;
		dtotal = (int)(total * 0.9);
		
		if(num>=20)
		{
			System.out.println("10% 할인적용됩니다.");
			System.out.printf("%s %d개의 할인가는 %d원입니다.",name,num,dtotal);
		}
		else if (num<20)
		{
			int more = 20 - num;
			System.out.printf("%d개 더 사시면 할인적용됩니다.\n",more);
			System.out.printf("할인 미적용된 총 가격은 %d원입니다.",total);
		}

}
}