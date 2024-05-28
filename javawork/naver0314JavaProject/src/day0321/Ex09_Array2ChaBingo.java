package day0321;

import java.util.Scanner;

public class Ex09_Array2ChaBingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][]=new int [3][3];
		int binggo=0;
		/*
		 * 1~3사이의 난수를 발생 후 가로,세로,대각선 방향으로
		 * 같은숫자가 나올경우 binggo 변수를 1증가하여 빙고개수를 구하고
		 * 같은 숫자가 없을경우 꽝!이라고 출력
		 */
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			
			binggo=0;
			//1~3의 값을 임의로 발생
			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<arr[i].length;j++)
				{
					arr[i][j]=(int)(Math.random()*3)+1;
				}
			}
			//출력
			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<arr[i].length;j++)
				{
					System.out.printf("%4d",arr[i][j]);
				}System.out.println("\n");
			}
			//빙고개수나 꽝 출력 arr[3][0]==arr[2][0]==arr[1][0]이면
			
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i][0]==arr[i][1] && arr[i][1]==arr[i][2])
					binggo++;
				if(arr[0][i]==arr[1][i] && arr[1][i]==arr[2][i])
					binggo++;
			}
			if(arr[2][0]==arr[1][1] && arr[1][1]==arr[0][2])
				binggo++;
			if(arr[0][0]==arr[1][1]&& arr[1][1]==arr[2][2])
				binggo++;
				
			if(binggo==0)
				System.out.println("꽝!");
			else 
				System.out.println("빙고:"+binggo);
			System.out.println("=".repeat(12));
			String ans=sc.nextLine();
			if(ans.equalsIgnoreCase("x"))
			{
				System.out.println("*** 빙고게임을 종료합니다 ***");
				break;
			}
			
		}
		
	}

}
