package day0322;

public class Ex05_CallBy {

	public static void changeNum(int n)
	{
		n=10;
	}
	public static void changeArray(int []a)
	{
		a[1]=56; a[2]=200;
	}
	static public void changeHome(String home)
	{
		home = "제주도";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=50;
		changeNum(n);//값만 전달한것. Call By Value (기본형은 모두 해당)
		System.out.println("n="+n);
		
		int []arr = {3,5,7};//배열은 객체로 인식
		changeArray(arr);//주소가 전달되었다는 뜻, Call By Reference
		//배열은 나눠서 작업해도 됨 주소가 다 전달되는 방식이라
		for(int a:arr)
		{
			System.out.printf("%4d",a);
		}System.out.println();
		
		String home="서울";
		System.out.println(home);
		changeHome(home);
		System.out.println(home);
		//String도 객체지만 Call By Value. 주소가 아닌 값만 전달
		
		
		
		
		
		
		
		
		
		
	}

}
