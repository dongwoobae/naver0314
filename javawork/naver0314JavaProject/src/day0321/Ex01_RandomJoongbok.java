package day0321;

public class Ex01_RandomJoongbok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1~30까지 난수 10개를 발생
		 * 중복처리하기
		 */
		
		int[] rand = new int[10];
		Loop:
		for(int i=0;i<rand.length;i++)
		{
			int n = (int)(Math.random()*30)+1;
			rand[i]=n;
			//중복처리
			for(int j=0;j<i;j++)//i이전까지 j를 돌림
			{
				if(rand[i]==rand[j])
				{
					i--;//다시 제자리로 가기 위해서 일단 1을 빼고 이동
					continue Loop;//i++로 이동
				}
			}
		}
		//순차적 정렬(오름차순)
		for(int i=0;i<rand.length-1;i++)
		{
			for(int j=i;j<rand.length;j++)
			{
				if(rand[i]>rand[j])
				{
					int temp = rand[i];
					rand[i]=rand[j];
					rand[j]=temp;
				}
			}
		}
		
		System.out.println("1부터 30 사이에 중복되지않은 난수 구하기");
		
		for(int i=0;i<rand.length;i++)
		{
			System.out.printf("%4d",rand[i]);
		}
		
		
		
		
		
		
		
	}

}
