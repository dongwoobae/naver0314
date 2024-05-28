package day0321;

import java.util.Scanner;

public class Book199_09correct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int inwon=0,num=0,max=0,sum=0;//초기값을 줘야 에러없어짐
		double avg=0;
		int []score=null;
		
		Exit:
		while(true)
		{
			System.out.println("-".repeat(50));
			System.out.println("1.학생수|2.점수입력 | 3. 점수리스트 | 4. 분석 | 5.종료");
			System.out.println("-".repeat(50));
			num = sc.nextInt();
			
			switch(num)
			{
				case 1:
					System.out.println("학생수>>");
					//배열 메모리 할당
					inwon = sc.nextInt();
					score = new int[inwon];
					break;
				
				case 2:
					for(int i=0;i<score.length;i++)
					{
						System.out.println("scores["+i+"] >>");
						score[i]=sc.nextInt();
					}
					break;
				
				case 3:
					System.out.println("*** 입력한 점수들 ***");
					for(int i=0;i<score.length;i++)
					{
						System.out.printf("%d번째 점수: %d점\n",i+1,score[i]);
					}
					break;
					
				case 4:
				//최대값 구하기
					max=score[0];//첫번째 점수를 최대값으로 지정
					//1번 데이터 부터 비교 후 max보다 클 경우 max 변경
					for(int i=1;i<score.length;i++)
					{
						if(max<score[i])
							max=score[i];
					}
				//총점, 평균 구하기
					sum=0;
					for(int s:score)
						sum+=s;
				//평균
					avg=(double)sum/inwon;
					System.out.println("** 성적 분석 결과 **");
					System.out.println("최고점수 : "+max);
					System.out.println("합계 : "+sum);
					System.out.printf("평균 : %5.2f\n\n",avg);
					break;
				
				default:
				{
					System.out.println("프로그램 종료");
					break Exit;
				}
			}
			System.out.println();
		}
	}

}
