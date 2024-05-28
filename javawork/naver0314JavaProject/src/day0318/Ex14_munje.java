package day0318;

import java.util.Scanner;

public class Ex14_munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int count = 0,sum =0, score;
		
		for(int i=1;i<=5;i++)
		{
			System.out.println("숫자 입력"+i);
			score=sc.nextInt();
			if(score<1||score>100)
			{
				continue;//다시 for문으로 이동
			}
			count++;
			sum+=score;
		}
		System.out.println("입력한 점수 개수: "+count);
		System.out.println("총 합계: "+sum);
		
		
		
		
	}	

}
