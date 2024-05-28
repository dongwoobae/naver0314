package day0320;

public class Ex06_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//배열을 선언하면서 초기값을 지정하는 경우
		int []arr1 = {4,6,8,10,30};
		System.out.println("**출력 #1 **");
		for(int i=0;i<arr1.length;i++)
		{
			System.out.printf("%4d",arr1[i]);
		}System.out.println();
		
		
		System.out.println("**출력 #2 **");
		for(int n:arr1)
		{
			System.out.printf("%4d",n);
		}
		System.out.println();
		System.out.println("=".repeat(20));
		
		int[]arr2;
		arr2=new int[] {10,20,30,40};//선언만 하고 나중에 값 주는 경우 new int를 붙이고 나열해주면 됨
		System.out.println("arr2의 개수:"+arr2.length);
		
		for(int n:arr2)
		{
			System.out.printf("%4d",n);
		}System.out.println();
		
		//문자열 배열
		String []str1= {"김영자","이미자","강호동","이재성"};
		String []str2;
		str2=new String[] {"사과","오렌지","딸기","수박","참외"};
		
		//출력 str1은 length를 이용해서 출력, str2는 두번째 방법 for문으로 출력
		
		for(int i=0;i<str1.length;i++)
		{
			System.out.printf("%d번째 단어: %3s ",i+1,str1[i]);
		}System.out.println();
		
		for(String a:str2)
		{
			System.out.printf("%s ",a);
		}System.out.println();
		
		
		
	}

}
