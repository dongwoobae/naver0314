package day0315;

import java.util.Scanner;

public class Ex6_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int kor,eng;
		String name;
		System.out.println("국어점수는?");
		kor=sc.nextInt();
		System.out.println("영어점수는?");
		eng = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("이름은?");
		name = sc.nextLine();/*정수 뒤에 문자열이 오면 enter키를 문자열로 읽어버림
		엔터가 버퍼에 저장이 되어있는 상태 sc.nextLine()을 넣어줘서 엔터를 씹어줄수잇음
		하지만 그냥 nextint를 안쓰고 nextline을 쓰는걸 권장
		 */
		System.out.println("이름:" +name);
		System.out.printf("국어점수: %d점, 영어점수:%d점\n",kor,eng);
		System.out.printf("총점 : %d점, 평균 : %d점",kor+eng,(kor+eng)/2);
		
		
		
	}

}
