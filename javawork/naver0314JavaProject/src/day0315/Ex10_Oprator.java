package day0315;

public class Ex10_Oprator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*증감연산자 
		 * 전치일 경우에는 1순위, 후치일 경우에는 끝순위
		 * 단, 단항일 경우에는 상관없음
		 */
		int m=5, n=5;
		int a=10, b=10;
		
		m++;
		n++;
		System.out.println("m= "+m);
		System.out.println("n= "+n);
		
		a+=m++;//a= a+m a에m을 더해라 라는뜻 //후치는 제일 마지막에 게산
		System.out.println("a="+a);//a를 먼저 계산 후 
		System.out.println("m= "+m);//m이 증가되서 6->7이됨
		
		b+=++n;//n이 먼저 증가된 후 b에 더해짐 
		System.out.println("b="+b);
		System.out.println("n="+n);
		
		 m=5;
		System.out.println(m++);//5로 출력후 메모리에서 6이됨
		n=5;
		System.out.println(++n);
		
		System.out.println("m="+m+",n="+n);
		
		
	}

}
