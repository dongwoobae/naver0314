package day0315;

public class Ex1_DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 한줄 주석
		/*여러줄 주석
		 * 
		 * 2024 03 15 자바 수업 둘째날
		 * 자바에서의 주석처리 방법
		 */
		//기본 자료형 공부 - 한글 다르면 깨짐. 한글 타입 파일 우클릭 후 properties -> 인코딩 타입 
		/*
		 * 첫글자 대글자는 클라스를 해당 문자로 
		 * 구역{} 안에서 선언하는 변수들은 자동초기화가 되지 않으므로 
		 * 초기값을 지정하거나 나중에 변수에 값을 전달해야 출력이 가능하다
		 */
		
		boolean flag=true;
		boolean flag2=false;
		
		System.out.println(flag);
		System.out.println(flag2);
		System.out.println(!flag);//! = not 반대로 출력
		System.out.println(!flag2);
		
		//&& 둘다 true 일때만 true   || 둘중 하나만 true여도 true
		System.out.println(flag && flag2);
		System.out.println(flag || flag2);
		
	}

}
