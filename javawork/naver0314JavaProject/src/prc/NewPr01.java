package prc;

import java.util.*;

class Solution {
    public int solution(int [] array) {
    	Arrays.sort(array);
    	int answer = 0;        
        int maxFr=1;
        int curFr=1;
        int maxNum=array[0];
        String a="0100";
                
        	
        for(int i=1;i<array.length;i++) {
        	
        	if(array[i]==array[i-1]) {
        		curFr++;
        		if(curFr>maxFr) {
        			maxFr=curFr;
        			maxNum=array[i];
        		}
        	}else {
        		curFr=1;
        	}
        }
        
        for(int i=0;i<array.length-maxFr+1;i++) {
        	if(array[i]==maxNum&&array[i+maxFr-1]==maxNum) {
        		answer=-1;
        		break;
        	}else {
        		answer=maxFr;
        		break;
        	}
        }
       
        return answer;
    }
}

public class NewPr01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] arr= {1,2,2,2,2,3,4,5,6,7,7,8,9};
		s.solution(arr);
		
		}
	}


