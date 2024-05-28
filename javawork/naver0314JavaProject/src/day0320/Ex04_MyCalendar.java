package day0320;

import java.util.Date;
import java.util.Scanner;

public class Ex04_MyCalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*연도와 월을 입력하면 해당 달력을 출력
		 * 만년 달력을 만들기 위해 알아야할 사항 2가지
		 * 1. 내가 입력한 연도-월의 1일이 무슨 요일인가
		 * 2. 내가 입력한 연도-월이 몇일까지 있는가?
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int year,month,week,endday;
		
		System.out.println("달력을 조회할 연도와 월을 입력하시오");
		System.out.println("연도?");
		year =sc.nextInt();
		System.out.println("월?");
		month=sc.nextInt();
		
		if(month<1||month>12)
		{
			System.out.println("잘못된 숫자입니다.");
			return;
		}
		
		System.out.printf("%23d 년 %d월 달력\n\n",year,month);
		
		System.out.println("=".repeat(50));
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		System.out.println("=".repeat(50));
		
		Date date = new Date(year-1900, month-1, 1);//내가 입력한 year와 month에서 빼줌
		week=date.getDay();//0이 일요일 ..6이 토요일
		//System.out.println(week);
		
		switch (month) {
		case 2: {
			endday=year%4==0&&year%100!=0||year%400==0?29:28;
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11:
			endday=30;
			break;
		default:
			endday=31;
		}
		//week(요일수) 만큼 탭으로 띄우기
		for(int i=1;i<=week;i++)
		{
			System.out.print("\t");
		}
		//1일부터 endday까지 출력
		//조건: 토요일 출력 후 \n으로 넘겨주기
		for(int i=1;i<=endday;i++)
		{
		System.out.printf("%2d\t",i);
		++week;//토요일이 되면 7의 배수가 됨
		if(week%7==0)
			System.out.println("\n");
		}
		
	}

}
