package day0319;

import java.util.Date;

public class Pprac2 {

	public static void main(String[] args) {
		Date date = new Date();
		int year = date.getYear()+1900;
		int month = date.getMonth()+1;
		int days = date.getDate();
		int week = date.getDay();

		String weekday[]={"일","월","화","수","목","금","토"};
		String s = week == 0 ? "일" : week == 1 ? "월" : week == 2 ? "화" : week == 3 ? "수" : week == 4 ? "목" : week == 5 ? "금" : "토";

		System.out.printf("%d년 %d월 %d일 %s요일",year,month,days,s);



	}
}