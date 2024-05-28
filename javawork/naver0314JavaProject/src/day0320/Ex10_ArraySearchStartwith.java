package day0320;

import java.util.Scanner;

public class Ex10_ArraySearchStartwith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String []members = {"강호동","한가인","유재석","이승민","강하나","손미나","이영자","박남정","한지혜","손창민"};

		String FName;
		int search=-1,count=0;
		
		while(true)
		{
			System.out.println("검색할 이름은?");
			FName = sc.nextLine();
			boolean match=false;
			if(FName.equalsIgnoreCase("q"))
			{
				System.out.println("종료합니다");
				break;
				}
			
			for(int i=0;i<members.length;i++)
			{
				
				match =members[i].startsWith(FName);
				
				if(match)
				{
					count++;
					search=i;
					System.out.printf("%d번째 : %s\n",i+1,members[i]);
				}
				
				}
			if(search==-1)
				{
					System.out.printf("\"%s\"라는 이름은 없습니다\n",FName);
					break;
				}
				else
					System.out.printf("총 %d명 검색\n",count);
			
				
			}
			
						
		}
		
		
		
		
	}


