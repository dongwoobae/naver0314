package day0320;

import java.util.Scanner;

public class Pprraacc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int data [] = {1,5,7,10,50,24,27,29,88,87,46,14};
		int num,searchIndex=-1;
		System.out.println("숫자를 입력하시오");
		num=sc.nextInt();
		for(int i=0;i<data.length;i++)
		{
			if(data[i]==num)
			{
				searchIndex=i;
				System.out.printf("%d는 %d번째에 있습니다",num,i+1);
				break;
			}
		}
		if(searchIndex==-1)
		{
			System.out.printf("%d은(는) 배열에 존재하지 않습니다",num);
		}
		
	}

}
