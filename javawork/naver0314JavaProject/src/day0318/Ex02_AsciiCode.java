package day0318;

public class Ex02_AsciiCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a ='A';
		char b = 65;//아스키 코드로 65는 대문자 A를 뜻함
		System.out.println(a+","+b);
		System.out.printf("a=%d,%c\n",(int)a,a);//내부적으로는 대문자 A를 65로 인식
		System.out.printf("b=%d,%c\n",(int)b,b);
		
		System.out.println(a+3);//68, char + int하면 int가 됨 대문자 D가 되는게 아니라 68이 됨.
		System.out.println((char)(a+3));//68을 char로 바꾼것
		
		char c = '7';
		System.out.println(c);//문자 7이 출력 숫자가 아님
		
		System.out.println(c+2);//문자7과 숫자2가 더해진것. 문자 7은 아스키코드 55
		//문자 7을 숫자 7로 표현하고 싶을 경우
		int n1 = c-48;//'0' or 48 빼면 됨
		
		System.out.println(n1);
		System.out.println(n1+2);
		
		
	}

}
