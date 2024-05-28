package day0322;

import java.text.SimpleDateFormat;

class MyShop
{
	private String sangpum;
	private String name;
	private int su,dan;
	private static String message;//공유되는 값
	
	public static final String SHOP= "24시간 이마트";
	
	//setter method
	public void setSangpum(String sangpum)
	{
		
		this.sangpum = sangpum;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void setSu(int su)
	{
		this.su = su;
	}
	public void setDan(int dan)
	{
		this.dan = dan;
	}
	static public void setMessage(String message)
	{
		//static 멤버변수는 같은 구역에 같은 이름의 변수가 있을 경우 앞에 클래스명을 생략하지않고 써주면 된다.
		MyShop.message=message;
	}
	//상품명,수량,단가를 한번에 변경하고 싶을 경우
	public void setData(String sangpum,int su, int dan)
	{
		//메소드 안에서 같은 멤버 메소드는 this로 호출이 가능
		this.setSangpum(sangpum);
		this.setSu(su);
		this.setDan(dan);
		
	}
	//overloading method (중복함수): 매소드명은 같으나 인자가 달라진다
	public void setData(String sangpum,int su, int dan,String message)
	{
		//메소드 안에서 같은 멤버 메소드는 this로 호출이 가능
		this.setSangpum(sangpum);
		this.setSu(su);
		this.setDan(dan);
		//인스턴스 메소드에서 static 메소드 호출
		setMessage(message);//앞에 클라스는 같은 클라스라 생략
		//static 메소드에서 인스턴스 메소드 호출 불가능. this가 없어서 호출 안됨
		//static 메소드에서 static 메소드 호출은 가능.
	}
	//출력은 getter가 아닌 일반 멤버 메서드로 만들어보자
	public void writeData()
	{
		System.out.println("상품명: "+sangpum);
		System.out.println("수량: "+su+"\t단가: "+dan);
		System.out.println("총금액: "+su*dan);
		System.out.println("오늘의 메세지: "+message);
		System.out.println("=".repeat(20));
	}



}
public class Ex03_StaticMethod {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyShop sang1= new MyShop();
		MyShop sang2= new MyShop();
		MyShop sang3= new MyShop();
		
		System.out.println("** 상품 1 **");
		sang1.setSangpum("딸기");
		sang1.setSu(3);
		sang1.setDan(3);
		MyShop.setMessage("오늘 각종 과일 세일합니다!");
		
		sang1.writeData();
		
		System.out.println("** 상품2 **");
		sang2.setData("수박",2,30000);
		sang2.writeData();
		
		System.out.println("** 상품3 **");
		sang3.setData("참외", 5, 2000, "오늘 세일 마감!");
		sang3.writeData();
		
		System.out.println("** 상품1 다시 출력 **");
		sang1.writeData();
		
		System.out.println("** 상품2의 수량만 변경 **");
		sang2.setSu(5);
		sang2.writeData();
		
		
		
		
		
		
	}

}
