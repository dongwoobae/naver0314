package day0319;

import java.util.Scanner;

public class PPrac {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		/*int sum=0;
		
		for(int i=1;i<=100;i++)
		{
			if(i%3==0)
			{
				sum+=i;
			}
		}
		System.out.println(sum);
		*/
		/*
		while(true)
		{
		int x = (int)(Math.random()*6)+1;
		int y =(int)(Math.random()*6)+1;
		
			if (x+y==5)
			{
				System.out.printf("%d,%d\n",x,y);
				break;
			}
			System.out.printf("%d,%d\n",x,y);
			}
	}*/

		for(int i=1;i<=10;i++)
		{
			for(int j=1;j<=10;j++)
			{
				int answer = 4*i + j*5;
				if(answer==60)
				{
					System.out.printf("%d,%d\n",i,j);
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
}