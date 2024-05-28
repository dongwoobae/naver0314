package day0327;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex03_SetLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Set<Integer> setLotto = new TreeSet<Integer>();
		
		while(true)
		{
			System.out.println("로또를 구입할 금액 입력");
			int money = sc.nextInt();
			if (money ==0)
			{
				System.out.println("종료합니다");
				break;
			}
			if (money<1000)
			{
				System.out.println("\t금액이 부족합니다");
				break;
			}
			//6개의 중복되지 않은 로또 숫자 구하기(1~45)
			for(int i=0;i<money/1000;i++)
			{
				setLotto.clear();//기존 값 모두 삭제 후 다시 구하기
				while(true)
				{
					int n = (int)(Math.random()*40)+6;
					setLotto.add(n);
					if(setLotto.size()==6)
						break;
				}
				System.out.printf("%3d회 : ",i+1);
				for(int l:setLotto)
				{
					System.out.printf("%d\t",l);
				}System.out.println();
			}
			
			
		}
	}
	
	
	
	
	
	
	
	
	
	

}
