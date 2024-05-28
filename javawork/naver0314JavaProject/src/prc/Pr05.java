package prc;

import java.util.Scanner;

public class Pr05 {
	class Solution {
	    public int[] solution(int[] num_list) {
	        int[] answer = {};
	        int a=0,b=0;
	        for(int i=0;i<num_list.length;i++){
	            if(num_list[i]%2==0){
	                a++;
	            }
	            else{
	                b++;
	            }
	        }
	        
	        
	        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[] num_list= {1,2,3,4,5};
		int[] answer = new int[2];
        int a=0,b=0;
        for(int i=0;i<num_list.length;i++){
            if(num_list[i]%2==0){
                a++;
            }
            else{
                b++;
            }
        }
        answer[0]=a;
        answer[1]=b;
        
        for(int i:answer) {
        	System.out.println(i);
        }
		
	}

}
