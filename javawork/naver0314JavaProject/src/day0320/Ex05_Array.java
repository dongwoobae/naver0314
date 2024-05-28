package day0320;

public class Ex05_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열 선언 방법
		int []arr1;
		//arr1에 배열에 몇개를 넣을지 개수만큼 할당
		arr1= new int[5];//이때 각 배열에는 초기값 0이 할당. 객체인 경우 초기값 null로 할당
		System.out.println("arr1의 개수:"+arr1.length);//괄호 없이 속성
		System.out.println("**arr1의 초기값 출력**");
		for(int i=0;i<arr1.length;i++)
		{
			System.out.println(i+":"+arr1[i]);
		}
		System.out.println("**배열의 일부값을 변경후 출력**");
		arr1[0]=5;
		arr1[4]=30;
		for(int i=0;i<arr1.length;i++)
		{
			System.out.println(i+":"+arr1[i]);
		}

		System.out.println("**다른방법으로 출력해보기**");//i값 필요없고 값만 출력
		for(int a:arr1)//바로 변수에 배열을 지정해줄 수 있음
		{
			System.out.println(a);
		}
		
		
		
		
		
	}

}
