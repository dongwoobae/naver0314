package day0320;

import java.util.Scanner;

public class Ex08_ArraySearchNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		/*
		 * 숫자(num)을 입력하여 배열의 몇번째에 있는지 출력
		 * 없을경우엔 없다고 메세지 출력, 반복해서 검색. 0 입력시 종료
		 */
		int[]data = {1,2,6,8,14,16,17,18,19,20};
		
		//System.out.println(data.length);
		int num,searchindex;
		while(true)
		{
			searchindex = -1;
			System.out.println("검색할 숫자를 입력하세요");
			num=sc.nextInt();
			if(num==0)
			{
	
				System.out.println("검색을 종료합니다.");
				break;
			}
			
			for(int i=0;i<data.length;i++)
			{
				if(num==data[i])
				{
					searchindex=i;
					break;
				}
			}
			if(searchindex==-1)
			{
				System.out.println("\t"+num+"은 데이터에 없습니다");
			}
			else
			{
				System.out.println("\t"+num+"은"+(searchindex+1)+"번째에 있습니다");
			}System.out.println();
		}
		
		
		
		
		
		
		
		}
		
		
		
	

}
