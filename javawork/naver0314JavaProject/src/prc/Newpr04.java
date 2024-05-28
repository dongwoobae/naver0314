package prc;

import java.util.*;
public class Newpr04 {
	 public int solution(int num, int k) {
	        int answer = 0;
	        String a = String.valueOf(num);
	        for(int i=0;i<a.length();i++){
	        if((a.charAt(i)-'0')==k){
	            return i;
	        }
	        }
	        return -1;
	    }
	 public String solution1(String my_string) {
	        String answer = "";
	        Vector<String> list = new Vector<String>();
	        for(int i=0;i<my_string.length();i++){
	        	char a = my_string.charAt(i);
	            list.add(String.valueOf(a).toLowerCase());
	        }
	        
	        String [] arr=new String [list.size()];
	        
	        for(int i=0;i<list.size();i++){
	            arr[i]=list.get(i);
	        }
	        Arrays.sort(arr);
	        for(int i=0;i<arr.length;i++) {
	        answer+=arr[i];
	        }
	        return answer;
	    }
	 public int solution3(int order) {
	        int answer = 0;
	        String a=String.valueOf(order);
	        for(int i=0;i<a.length();i++){
	        char b = a.charAt(i);
	            if(String.valueOf(b).equals("3")) {
	            	answer++;
	            }else if(String.valueOf(b).equals("6")) {
	            	answer++;
	            }else if(String.valueOf(b).equals("9")) {
	            	answer++;
	            }
	        }
	        return answer;
	    }
	 public static void main(String[] args) {
		Newpr04 pr = new Newpr04();
		System.out.println(pr.solution3(73399));
	}
}
