package day0318;

import java.util.Scanner;

public class practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * System.out.println("구구단 출력");
		 
		
		for(int i=2;i<=9;i++)
		{
			for(int j=1;j<=9;j++)
			{
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
		}
		*/
		/*int x;
		System.out.println("1~5 중 아무 숫자를 누르시오");
		x = sc.nextInt();
		
		Number:
		switch (x) {
		case 1:
			System.out.println("하나");break;
		case 2:
			System.out.println("둘");break;
		case 3:
			System.out.println("셋");break;
		case 4:
			System.out.println("넷");break;
		case 5:
			System.out.println("다섯");break;
		default:
			System.out.println("1~5중 숫자를 누르시오");
		*/
		
		int year,month,day;
		System.out.println("연도를 입력하시오");
		year = sc.nextInt();
		boolean flag;
		
		if(year%4==0&&year%100!=0||year%400==0)
		{
			flag = true;
			System.out.printf("%d년은 윤년입니다.\n",year);
		}
		else
		{ 
			flag = false;
			System.out.printf("%d년은 평년입니다.",year);
		}
			
		
		System.out.println("월을 입력하시오");
		month = sc.nextInt();
		if(month>12||month<1)
		{
			System.out.println("잘못 입력했어요!");
			return;
		}
		else if(month==2)
		{
			day=flag?29:28;
		}
		else if(month==4||month==6||month==9||month==11)
		{
			day=30;
		}
		else
		{
			day=31;
		}
		System.out.printf("%d년의 %d월은 %d일까지 있습니다.",year,month,day);
		}
	
		
		
			
		
	
	
	}

