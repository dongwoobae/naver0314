package prc;

import java.util.ArrayList;
import java.util.List;

interface Orange
{
    public void write();
}





public class Prctice {

    Orange or = new Orange() {

        @Override
        public void write() {
            System.out.println("오렌지다~");
        }
    };
    public void lambdaMethod()
    {
        Orange or2 = ()->System.out.println("람다식 오렌지");
        or.write();

        Orange or3=()->
                System.out.println("안녕하세요");
                System.out.println("람다식 공부중");
                or3.write();

        Orange or4= new Orange() {
            @Override
            public void write() {
                System.out.println("다양한 방법으로 구현");
            }

        };
        or4.write();
        
    }
    class Solution {
        public int solution(String binomial) {
            int answer = 0,stop=0;
            String a="",b="",c="";
            
           for(int i=0;i<binomial.length();i++){
               try {
            	   a+=Integer.parseInt(String.valueOf(binomial.charAt(i)));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				stop=i+1;
				c=String.valueOf(binomial.charAt(i));
				break;
			}  
            
           }
           for(int i=stop;i<binomial.length();i++) {
           	b+=Integer.parseInt(String.valueOf(binomial.charAt(i)));
           }
           if(c=="+") {
        	   answer = Integer.parseInt(a)+Integer.parseInt(b);
           }else if(c=="-"){
        	   answer = Integer.parseInt(a)-Integer.parseInt(b);
           }else {
        	   answer=Integer.parseInt(a)*Integer.parseInt(b);
           }
            return answer;
        }
    }

    public static void main(String[] args) {
       



    }
}
