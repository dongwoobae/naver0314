package day0319;

import java.util.Calendar;
import java.util.Date;

public class Ex09_DateCalender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Date 클래스를 이용해서 년,월,일,시,분,초 얻기 (JDK1.1이후 calendar를 권장하나 여전히 많이 씀)
		Date date=new Date();//디폴트로 생성시 현재 날짜와 시간을 얻는다
		int year=date.getYear()+1900;
		int month = date.getMonth()+1;
		int day = date.getDate();
		int week = date.getDay();//0이 일요일부터 6 토요일
		int hour = date.getHours();
		int minute=date.getMinutes();
		int second=date.getSeconds();
				
		System.out.println("현재년도: "+year);//1900이 빠진값 반환
		System.out.println("현재 월: "+month);//0~11이 반환되서 +1을 해줘야 우리가 쓰는 월이됨
		System.out.println("현재 일: "+day);
		System.out.println("현재 요일: "+week+"("+
				(week==0?"일":week==1?"월":week==2?"화":week==3?"수":week==4?"목":week==5?"금":"토")+")"
				);//요일은 숫자로 반환
		System.out.printf("%d시 %d분 %d초\n",hour,minute,second);
		System.out.println("=".repeat(30));
		
		//calendar 이용해서 출력
		
		Calendar cal= Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH)+1;//month는 거의 다 +1해줘야됨
		day=cal.get(Calendar.DATE);
		
		System.out.printf("%d년 %d월 %d일입니다.",year,month,day);
		
		
		
		
		
		
	}

}
