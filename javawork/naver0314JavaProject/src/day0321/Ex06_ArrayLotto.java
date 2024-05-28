package day0321;

import java.util.Scanner;

public class Ex06_ArrayLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int[]lotto = new int[6];
		int money;
		
		
		
		while(true)
		{
			System.out.println("로또금액 입력");
			money=sc.nextInt();
			int num = money/1000;
			if(money<1000&&money>0)
			{
				System.out.println("금액이 부족합니다.");
				continue;
			}
			else if (money==0)
			{
				System.out.println("종료합니다");
				return;
			}
			
			for(int m=0;m<num;m++)
			{
			for(int i=0;i<lotto.length;i++)
			{
				lotto[i]=(int)(Math.random()*40)+6;
			}
			Woop:
			for(int i=0;i<lotto.length;i++)
			{
				for(int j=0;j<i;j++)
					if(lotto[i]==lotto[j])
					{
						i--;
						continue Woop;//해당 포문 아래에 다른코드가 없으므로 continue대신 break 써도 됨
					}
			}
			for(int i=0;i<lotto.length-1;i++)
			{
				for(int j=i+1;j<lotto.length;j++)
				{
					if (lotto[i]>lotto[j])
					{
						int temp = lotto[i];
						lotto[i]=lotto[j];
						lotto[j]=temp;
					}
				}
			}
				
				
			
			System.out.println((m+1)+"회차:");
				for(int n:lotto)
					System.out.printf("%3d",n);
				System.out.println();	
		}
		
		}
	}

}
