package day0315;

public class Ex4_MainArgs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//args- 배열 
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		System.out.println(args[2] + args[3]);//10 20을 그냥 문자열로 인식
		int s1 = Integer.parseInt(args[2]);//10과 20을 정수로 변환 
		int s2 = Integer.parseInt(args[3]);
		
		System.out.println(s1+s2);
		
		
		
		
		
	}

}
