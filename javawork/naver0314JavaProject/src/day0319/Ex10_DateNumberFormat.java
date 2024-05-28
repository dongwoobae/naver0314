package day0319;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex10_DateNumberFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//현재 날짜를 문자열로 출력하기
		Date date=new Date();
		
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEE");
		System.out.println(sdf1.format(date));//2024-03-19 16:33:48 화
		
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss EEEE");
		System.out.println(sdf2.format(date));//2024-03-19 오후 04:33:48 화요일

		SimpleDateFormat sdf3=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초 EEEE");
		System.out.println(sdf3.format(date));
		
		//숫자 포맷양식 지정하기
		int money=5678900;
		double average = 98.7611;
		
		NumberFormat nf1= NumberFormat.getCurrencyInstance();
		System.out.println(nf1.format(money));//화폐단위와 3자리마다 컴마가 출력됨
		
		//따로 생성없이 바로 메서드 호출해도 됨
		System.out.println(NumberFormat.getInstance().format(money));//화폐단위 유무 차이. 컴마만 추가됨
		
		//평균값을 소수점이하 한자리로 출력
		
		NumberFormat nf2=NumberFormat.getInstance();
		System.out.println(nf2.format(average));
		nf2.setMaximumFractionDigits(1);
		System.out.println(nf2.format(average));//반올림됨
		
		
		
		
		
	}

}
