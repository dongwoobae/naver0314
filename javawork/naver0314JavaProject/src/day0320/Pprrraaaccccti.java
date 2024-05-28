package day0320;

import java.util.Scanner;

public class Pprrraaaccccti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
Scanner sc= new Scanner(System.in);
		
		String []members = {"강호동","한가인","유재석","이승민","강하나","손미나","이영자","박남정","한지혜","손창민"};
		String name;
		int search=-1,count=0;
		
		
		
		
		while(true)
		{
			System.out.println("성을 입력하시오");
			name=sc.nextLine();
			
			if(name.equalsIgnoreCase("q"))
			{
				System.out.println("종료합니다");
				return;
			}
			for(int i=0;i<members.length;i++)
			{
			if(members[i].startsWith(name))
			{
				count++;
				search = i;
				System.out.println((i+1)+"번째: "+members[i]);
			
			}
			}
			if(search==-1)
			{
				System.out.printf("%s님은 리스트에 없습니다\n",name);
				
			}else
			{
				System.out.printf("총 %d명\n",count);
				
			}
			
		}
	}

}
