package day0321;

import java.util.Scanner;

public class Book199_09If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		
		int[] score;
		int num,select,sum=0;
		
		while(true)
		{
			System.out.println("-".repeat(50));
			System.out.printf("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료\n");
			System.out.println("-".repeat(50));
			select = sc.nextInt();
			
			if(select==1)
			{
			System.out.println("선택> "+select+"\n");
			System.out.println("학생수?");
			
			}
			num=sc.nextInt();
			score = new int [num];
			
			System.out.println("-".repeat(50));
			System.out.printf("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료\n");
			System.out.println("-".repeat(50));
			select = sc.nextInt();
			if(select==2)
			{
				System.out.println("선택> "+select+"\n");
			
			for(int i=0;i<num;i++)
			{
			System.out.println("점수입력");
			score[i]=sc.nextInt();
			}
			}
			System.out.println("-".repeat(50));
			System.out.printf("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료\n");
			System.out.println("-".repeat(50));
			select = sc.nextInt();
			if(select==3)
			{
				System.out.println("선택> "+select+"\n");
				for(int i=0;i<num;i++)
				{
					System.out.printf("score[%d]: %d\n",i,score[i]);
				}
			}
			System.out.println("-".repeat(50));
			System.out.printf("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료\n");
			System.out.println("-".repeat(50));
			select = sc.nextInt();
			if(select==4)
			{
				System.out.println("선택> "+select+"\n");
			for(int i=0;i<score.length;i++)
			{
				for(int j=0;j<i;j++)
				{
					if (score[i]<score[j])
					{
						int temp=score[i];
						score[i]=score[j];
						score[i]=temp;
					}
				}
			}
			System.out.println("최고점수: "+score[0]);
			for(int i=0;i<num;i++)
			{
				sum+=score[i];
			}
			System.out.printf("평균점수: %.2f\n",(double)(sum)/num);
			}
		
			System.out.println("-".repeat(50));
			System.out.printf("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료\n");
			System.out.println("-".repeat(50));
			select = sc.nextInt();
			if(select==5)
			{
				System.out.println("선택> "+select+"\n");
				System.out.println("프로그램 종료");
				return;
				
			}
			
	}

	}
}