package day0319;

public class XYYXProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=9;i++)
		{
			for(int j=1;j<=9;j++)
			{
				/*if(11*i+11*j==121)
				{
					System.out.printf("(%d,%d)\n",i,j);
				}*/
				int susik = (i*10+j)+(j*10+i);
				if(susik==121)
				System.out.printf("%d%d+%d%d=121\n",i,j,j,i);
			}
		}
		
		
		
		
		
	}

}
