package prc;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

class Solution1 {
    public int[] solution(String my_string) {
        int[] answer = {};
        Vector<Integer>ans=new Vector<Integer>();
        for(int i=0;i<my_string.length();i++) {
        char ch=my_string.charAt(i);
        
        try{int num= Integer.parseInt(Character.toString(ch));
        ans.add(num);}
        catch (Exception e) {
			// TODO: handle exception
		};		
        }
        for(int i=0;i<ans.size();i++) {
        	if(ans.get(i)==0) {
        		ans.remove(i);
        	}
        }
        answer=new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
        	answer[i]=ans.get(i);
        }
        Arrays.sort(answer);
        
        
        
        return answer;
    }
}
public class Newpr02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
