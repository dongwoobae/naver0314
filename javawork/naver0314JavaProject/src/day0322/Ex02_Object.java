package day0322;

import java.util.Scanner;

class Orange{
	//private이라는 접근 지정자는 같은 클래스 내에서만 접근이 가능
	//멤버 변수는 자동 초기화
	private String name;
	private int age;
	
	private static String company = "삼성";
	
	
	//getter 메소드 : 멤버변수값을 반환하는 메소드(규칙 getName,getAge)get은 소문자 뒤에 단어는 첫글자 대문자
	public String getName()
	{
		return name;//같은 구역안에 같은 name이라는 이름이 없을경우에만 this 생략가능
		//return this.name 의 this가 생략된것 
		//this: 일반 멤버메소드에만 존재, static 메소드에는 없음
	}
	public int getAge()
	{
		return this.age;
	}
	//setter 메소드의 목적은 외부로부터 값을 받아서 멤버변수의 값을 변경
	public void setName(String name)
	{
		this.name = name;//인자에 있는 name값을 멤버변수 name으로 전달
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	//static 변수를 반환하는 메소드
	public static String getCompany()
	{
		return company;
	}
}



public class Ex02_Object {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Orange or = new Orange();
		System.out.println("초기값 확인");
		System.out.println("name: "+or.getName());
		System.out.println("age: "+or.getAge());
		
		or.setName("옥순이");
		or.setAge(23);
		System.out.println("name: "+or.getName());
		System.out.println("age: "+or.getAge());
		
		System.out.println("회사명: "+Orange.getCompany());
	}
}
