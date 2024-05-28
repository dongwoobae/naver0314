package day0319;

import java.util.Scanner;

public class Ex07_Whilemunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int score,count=0,sum=0;
		
		while(true)
		{
			System.out.printf("%d번째 점수를 입력하십시오\n",count+1);
			score=sc.nextInt();
			if (score>100||score<0)
			{
				continue;
			}
			else if(score<=100&&score>0)
			{
				sum+=score;
				count++;
			}
			else
			{
				System.out.printf("총 합계점수: %d점\n",sum);
				System.out.printf("입력된 점수 개수: %d개",count);
				break;

			}
		}
	}

}
