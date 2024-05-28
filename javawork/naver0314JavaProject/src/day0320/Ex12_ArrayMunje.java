package day0320;

import java.util.Scanner;

public class Ex12_ArrayMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 인원수를 입력받아 해당 인원수만큼
		 * name,koe,eng,tot,rank 변수를 배열하고 
		 * 인원수만큼 이름 국어점수 영어점수를 입력하면 총점과 등수를 출력
		 * ------------------------
		 * 번호 이름 국어 영어 총점 등수
		 * -------------------------
		 */
		Scanner sc = new Scanner(System.in);
		int p;
		System.out.println("인원수를 입력하시오");
		p=Integer.parseInt(sc.nextLine());
		
		
		String []name;
		int[]koe;
		int[]eng;
		int[]tot;
		int[]rank;

		name = new String [p];
		koe = new int [p];
		eng = new int [p];
		tot = new int [p];
		rank = new int [p];
		
		for(int i=0;i<koe.length;i++)
		{
			
		System.out.println((i+1)+"번째 이름을 입력하시오");
		name[i]=sc.nextLine();
		System.out.println("국어점수를 입력하시오");
		koe[i]=Integer.parseInt(sc.nextLine());
		System.out.println("영어점수를 입력하시오");
		eng[i]=Integer.parseInt(sc.nextLine());
		tot[i]=koe[i]+eng[i];
		}
		for(int i=0;i<koe.length;i++)
		{
			rank[i]=1;
			for(int j=0;j<koe.length;j++)
			{
				if(tot[i]<tot[j])
				{
					rank[i]++;
				}
			}
		}
		System.out.println("=".repeat(50));
		System.out.println("번호"+"\t"+"이름"+"\t"+"국어"+"\t"+"영어"+"\t"+"총점"+"\t"+"등수");
		//"번호\t이름\t...이런식으로 쓰면 됨
		System.out.println("=".repeat(50));
		for(int i=0;i<koe.length;i++)
		{
		System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\n",i+1,name[i],koe[i],eng[i],tot[i],rank[i]);
		}
		
		
		
	
	}
}
