package day0315;

import java.util.Scanner;

public class Ex12_munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score;
		System.out.println("점수를 입력하시오.");
		score = sc.nextInt();
		
		String msg1 = "\"참 잘했어요!\"", msg2 = "\"수고했어요!\"", msg3 = "\"조금 더 노력하세요!\"", msg4 = "\"재시험입니다!\"";
		String msg;
		
		msg = score>=90?msg1:
				score>=80?msg2:
					score>=70?msg3:
						msg4;
		
		System.out.println(msg);
		System.out.println(score+"점 \n"+msg);			
						
		/**dfdfdf
		 * 
		 */
		
		
		
		
			
		
		
		
		
	}

}
