package prc;

import java.util.Scanner;

public class Book_107 {
	int moneySaved=10000,moneyOut=0,moneyLeft,moneyExit=0;


	public void getMenu()
	{
		System.out.println("=".repeat(30));
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
		System.out.println("=".repeat(30));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book_107 b = new Book_107();

		Scanner sc = new Scanner(System.in);
		while(true)
		{
			b.getMenu();
			int a = Integer.parseInt(sc.nextLine());
			switch (a)
			{
			case 1: 
			{
				System.out.println("선택> 1");
				System.out.println("\n\n예금액> "+b.moneySaved);
				break;
			}
			case 2:
			{
				System.out.println("선택> 2");
				b.moneyOut=Integer.parseInt(sc.nextLine());
				System.out.println("\n\n출금액> "+b.moneyOut);
				b.moneyLeft=b.moneySaved-b.moneyOut;
				break;
			}
			case 3:
			{
				System.out.println("선택> 3");				
				System.out.println("\n\n잔고> "+(b.moneyLeft));
				b.moneySaved=b.moneyLeft;
				break;
			}
			case 4:
			{
				System.out.println("선택>4");
				System.out.println("\n\n프로그램 종료");
				System.exit(0);
			}
			default:
				System.out.println("잘못된 번호입니다");
				break;
				
			}
		}


	}

}
