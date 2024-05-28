package day0320;

import java.util.Date;
import java.util.Scanner;

public class Calendar_prac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int year,month,days,week,endday;
        System.out.println("출력할 년도를 입력하십시오");
        year = sc.nextInt();
        System.out.println("출력한 월을 입력하십시오");
        month=sc.nextInt();
        Date date = new Date(year-1900,month-1,1);

        if(month>12||month<1)
        {
            System.out.println("잘못된 month입니다");
            return;
        }
        System.out.printf("%d년 %d월 달력\n\n", year, month);
        System.out.println("=".repeat(30));
        System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
        System.out.println("=".repeat(30));
        switch (month){
            case 2: {endday=year%4==0&&year%100!=0||year%400==0?29:28;
                break;}
            case 4,6,9,11:{
                endday=30;
                break;
            }
            default:
                endday=31;
                break;
        }
        week=date.getDay();
        for(int i=1;i<=week;i++)
        {
            System.out.println("\t");
        }
        for(int i=1;i<=endday;i++)
        {
            System.out.printf("%2d\t",i);
            ++week;
            if((week)%7==0)
                System.out.println("\n");
        }
    }
}
