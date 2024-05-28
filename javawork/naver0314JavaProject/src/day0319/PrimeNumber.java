package day0319;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		
		Loop:
		for(int i=2;i<=100;i++)
		{
		for(int j=2;j<=(i-1);j++)
		{
			if(i%j==0)
			{
				continue Loop;//Loop 레이블로 이동
			}
			
			
		}
		count++;
		System.out.printf("%3d",i);
		if(count%7==0)
			System.out.printf("\n");//카운트로 숫자 세기. 7칸 후 줄바꿈 = println();
	
		}
		System.out.printf("\n소수의 개수: %d",count);
	}

}
