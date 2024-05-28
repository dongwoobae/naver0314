package practice;

public class Pr_04 {
	class Solution {
	    public String solution(String[] str_list, String ex) {
	        String answer = "";
	        
	        for(int i=0;i<str_list.length;i++)
	        {
	        	String a = str_list[i];	 
	        	int check=0;
	        	for(int j=0;j<ex.length();j++)
	        	{
	        		String b= String.valueOf(ex.charAt(j));
	        		if(a.contains(b))
	        		{
	        			check++;
	        		}
	        	}
	        	if(check==0) {
	        		answer+=a;
	        	}
	        } 
	        return answer;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ex ="abcdefg";
		for(int j=0;j<ex.length();j++) {
		String b= String.valueOf(ex.charAt(j));
		System.out.println(b);
		}
	}

}
