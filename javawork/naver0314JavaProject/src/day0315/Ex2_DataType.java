package day0315;

public class Ex2_DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//정수 타입
		byte a = 127;
		System.out.println(a);
		
		byte b = (byte) 800;//cast 연산자  강제로 형변환, 값손실이 발생
		System.out.println(b);//-56? 값손실이 발생할 경우 엉뚱한 값이 출력이 되는데 내부적으로는 2의 보수값
								// 2의 지수값을 뺀 값이 나온다
		//실수 타입
		float f1 = 123.56789123456f; //f를 붙여야 float으로 저장 보통 8자리까지
		double f2 = 123.56789123456789123;//보통 15자리까지
		
		System.out.println(f1);
		System.out.println(f2);
		
		//1글자 지정은 char, 문자열은 String(객체타입)
		
		char ch1 = 'A';
		char ch2 = '닥'; //2바이트라 한글 한글자도 가능
		System.out.println(ch1);
		System.out.println(ch2);
		
		//문자열 지정하는 방법
		String str1 = new String("happy");//방법1
		String str2 = "hello";//방법2
		
		System.out.println(str1);
		System.out.println(str2);
		
		//긴 문자열을 지정하는 경우
		String str3 = "아아아아아어어어어어오오옹오오어어어어어어어어아아아아아오오오오오오오";
		String str4 = "아아아아아어어어어어\n"
				+ "아아아아아오오오오오오오\n" 
				+"아아아아아오오오오오오오\n";
		System.out.println(str3);
		System.out.println(str4);
		
		//jdk 15부터 가능, 텍스트 블록
		String str5 = """
				아아아아아어어어어어
				아아아아아오오오오오오오
				아아아아아오오오오오오오
				""";
		
		System.out.println(str5);
		
		System.out.println();//한줄띄움
		
	}

}
