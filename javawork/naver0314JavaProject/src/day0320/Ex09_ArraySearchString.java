package day0320;

import java.util.Scanner;

public class Ex09_ArraySearchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		
		String []members = {"강호동","한가인","유재석","이승민","강하나","손미나","이영자","박남정","한지혜","손창민"};
		
		int searchindex;
		String name;
		
		while(true)
		{
			System.out.println("찾을 이름을 입력하시오");
			name = sc.nextLine();
			searchindex=-1;
			if(name.equalsIgnoreCase("q"))
			{
				System.out.println("이름 찾기를 종료합니다");
				break;
			}
			for(int i=0;i<members.length;i++)
			{
				if(name.equals(members[i]))
				{
					searchindex=i;
					System.out.printf("%s님은 %d번째에 있습니다.\n",name,i+1);
					break;
				}
			}
			if(searchindex==-1)
			{
				System.out.printf("%s님은 리스트에 존재하지 않습니다.\n",name);
			}
		}
			
		
		
		
		
		
		}
	}


