package prc;

import java.util.Scanner;

public class BlackJack {
	String card;
	String cardNum;
	int choice;
	public String card() {
		 choice= (int)(Math.random()*52+1);
		
		if (choice>=1&&choice<=13)
			card="스페이드";
		else if (choice>=14&&choice<=26)
			card="다이아";
		else if (choice>=27&&choice<=39)
			card="클로버";
		else
			card="하트";
		
		
		if(choice%13<=9&&choice%13>=1)
			cardNum=" "+Integer.toString(choice%13+1);
		else if (choice%13==0)
			cardNum="Ace";
		else if (choice%13==10)
			cardNum="Jack";
		else if (choice%13==11)
			cardNum="Queen";
		else 
			cardNum="King";
		
		return card+" "+cardNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlackJack bj = new BlackJack();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("게임시작하려면 아무글자, 종료하려면 x를 누르시오");
		String a = sc.nextLine();
		if(a.equalsIgnoreCase("x"))
			return;
		
		int score=0,score1=0;
		for(int i=0;i<2;i++)
		{
			bj.card();
			System.out.println("참가자 카드: "+bj.card+" "+bj.cardNum);
			if(bj.choice%13<=9&&bj.choice%13>=1)
				score+=(bj.choice%13+1);
			else if(bj.choice%13==0)
				score+=1;
			else
				score+=10;
		}
		System.out.println("현 점수: "+score);
		while(score1<=16) {
			bj.card();
			if(bj.choice%13<=9&&bj.choice%13>=1)
				score1+=(bj.choice%13+1);
			else 
				score1+=10;
		}
		
		
		 while(true)
		 {
			 System.out.println("카드 한장 더 받으시겠습니까?\ny/n");
			 String y = sc.nextLine();
			 if(y.equalsIgnoreCase("y")) {
				 bj.card();
				 System.out.println("참가자 카드: "+bj.card+bj.cardNum);
				 if(bj.choice%13<=9&&bj.choice%13>=1)
						score+=(bj.choice%13+1);
					else 
						score+=10;
				 System.out.println("현 점수: "+score);
				 if(score>21) {
					 System.out.println("참가자 패배");
				 return;}
				 else if(score==21)
				 {
					 System.out.println("Black Jack!");
					 break;
				 }
				 }
			 else if(y.equalsIgnoreCase("n"))
				 break;
			 
			 else
			 {
				 System.out.println("y,n 입력 요망");
			 }
			
		 }
		 
		 if(score1>21)
		 {
			 System.out.println("딜러점수: "+score1);
			 System.out.println("참여자 점수: "+score);
			 System.out.println("참가자 승!");
		 }
		 else if(score>score1)
		{
			System.out.println("딜러점수: "+score1);
			System.out.println("참여자 점수: "+score);
			System.out.println("참여자 승!");
		}
		else if(score<score1&&score1<=21)
		{
			System.out.println("딜러점수: "+score1);
			System.out.println("참여자 점수: "+score);
			System.out.println("참여자 패배!");
		}
		else {
			System.out.println("딜러점수: "+score1);
			System.out.println("참여자 점수: "+score);
			System.out.println("무승부");
		}
		
		 
}

}
