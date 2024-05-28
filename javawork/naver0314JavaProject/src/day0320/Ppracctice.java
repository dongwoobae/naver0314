package day0320;

import java.util.Scanner;

public class Ppracctice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] members = {"강호동","한가인","유재석","이승민","강하나","손미나","이영자","박남정","한지혜","손창민"};
		
		int searchIndex=-1;
		System.out.println("이름을 입력하시오");
		String name;
		name = sc.nextLine();
		
		
		for(int i=0;i<members.length;i++)
		{
			if(members[i].equals(name))
			{
				searchIndex=i;
				System.out.printf("\"%s\"님은 %d번째에 있습니다.",name,i+1);
				break;
			}
		}
		if(searchIndex==-1)
		{
			System.out.printf("\"%s\"님은 리스트에 없습니다.",name);
		}
		
	}

}
