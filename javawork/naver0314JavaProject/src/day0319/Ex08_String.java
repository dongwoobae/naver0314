package day0319;

import java.util.StringTokenizer;

public class Ex08_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str1="Have A Nice Day";
		String str2="apple";
		String str3="Apple";
		
		System.out.println(str1.charAt(7));//7번 인덱스의 문자(셀때 0,1,2,3,..으로 셈)
		System.out.println(str1.charAt(0));
		System.out.println(str1.indexOf('a'));//해당문자의 위치 찾기
		System.out.println(str1.indexOf('X'));//문자가 없을 경우 -1이 나옴
		System.out.println(str1.lastIndexOf('a'));//해당문자가 여러개일경우 마지막것의 위치
		System.out.println(str1.length());//해당 string의 총 길이
		System.out.println(str2.concat("***"));//해당 string에 더하기
		System.out.println(str2+"***");//위와 같음
		System.out.println(str1.toLowerCase());//모두 소문자로 변환해서 반환
		System.out.println(str1.toUpperCase());//모두 대문자로 변환해서 반환
		
		//문자열 비교시 (값으로 비교시 equal 사용)
		System.out.println("apple".equals(str2));
		System.out.println("apple".equals(str3));//대소문자 다르게 인식함 
		System.out.println(str2.equalsIgnoreCase(str3));//ignorecase로 대소문자 무관하게 
		System.out.println(str2==str3);//객체시 ==는 주소를 비교. 동등연사자는 기본값 비교시에만 사용(int,double등)
		
		//compare to로 비교
		System.out.println("apple".compareTo("append"));//7이 나옴. 순서상으로 첫 문자열이 뒤에 있으면 양수.앞에 있으면 음수
		System.out.println("apple".compareTo("banana"));//-1. a가 b보다 하나 앞이라 음수가 나옴.
		System.out.println("apple".compareTo(str2));//완전히 같을 경우 0
		System.out.println("apple".compareTo(str3));
		
		
		//문자열 추출
		System.out.println(str1.substring(7));//7번 인덱스부터 끝까지 추출.
		System.out.println(str1.substring(7, 9));//7~8까지만 추출. Ni만 나옴.
		System.out.println(str1.startsWith("Have"));//~~로 시작하는가.대소문자 구분 필요
		System.out.println(str1.startsWith("have"));
		
		System.out.println(str1.endsWith("day"));//~~로 끝나는가. 대소문자 구분 필요
		System.out.println(str1.toLowerCase().endsWith("day"));//이처럼 소문자 혹은 대문자로 변환후 가능
		
		//반복할때
		System.out.println(str2.repeat(3));
		System.out.println("*".repeat(10));
		
		//변경
		System.out.println(str1.replace('a', '*'));//char 형식
		System.out.println(str1.replace("Nice", str3));//문자열 통째로 
		
		//문자열 분리(결과값이 배열타입)
		String colors = "red,blue,green,yellow,pink";
		//,로 분리를 하고싶을경우
		String []a1=colors.split(",");
		System.out.println("분리된 배열의 개수: "+a1.length);//쉼표를 기준으로 분리해서 5개로 분리됨 (0번,1번...4번 이렇게)
		System.out.println(a1[0]+","+a1[4]);//분리된 문자열의 0번과 4번을 출력
		
		//분리하는 또다른 방법
		StringTokenizer st=new StringTokenizer(colors, ",");
		System.out.println("분리할 토큰수: "+st.countTokens());
		//분리된 토큰값 출력
		while(st.hasMoreTokens())//더이상 토큰이 없을경우 false가 되면서 while문을 빠져나간다.
		{
			System.out.println(st.nextToken());
		}
		
		//앞뒤 공백 제거해주기
		String msg = "  hello    ";
		System.out.println(msg.length());
		System.out.println(msg.trim().length());
		System.out.println(msg);
		System.out.println(msg.trim());
		
		//valueOf: 어떤 타입의 데이터도 String으로 변환해준다
		System.out.println(String.valueOf(3));//문자열 "3"으로 변환
		System.out.println(3+"");//이것도 문자열 3으로 인식
		
		
		
		
	}

}
