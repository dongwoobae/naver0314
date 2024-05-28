package day0318;

import java.util.Scanner;

public class Ex05_Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int year,month,days;
		boolean flag;//true false를 저장하는 용도
		
		System.out.println("연도를 입력하세요");
		year = sc.nextInt();
			if(year%4==0 && year%100!=0 || year%400==0)//정확한 윤년공식
			{
				flag=true;
			System.out.println(year+"년은 윤년입니다.");
			}else {
				flag=false;
				System.out.println(year+"년은 평년입니다.");
			}
			
		System.out.println("월을 입력하세요");
		month=sc.nextInt();
		if (month>12 || month<1) {
		System.out.println("잘못 입력했어요!");
		return;//메인 메서드 종료
		}
		/*switch(month)
		{
		case 2:
			//days=flag==true?29:28;
			days=flag?29:28;//위와 같은 코드 flag가 트루
			break;
		case 4: case 6: case 9: case 11:
			days=30;
			break;
		default:
			days=31;	
		}*/
		
		
		if(month==2)
		{
			days=flag?29:28;
		}else if(month==4||month==6||month==9||month==11) {
			days=30;
		}else {
			days=31;
		}
	
			System.out.println(year+"년 "+month+"월은 "+days+"일까지 있습니다.");
			
			
			
			}
		
		
		
		
	}


