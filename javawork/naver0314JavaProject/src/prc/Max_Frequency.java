package prc;
import java.util.*;
public class Max_Frequency {
	class solutionFor{
		public int solution(int [] array) {
			int answer=0;
			//배열 요소를 저장하기 위한 맵 생성
			HashMap<Integer, Integer> countMap= new HashMap<Integer, Integer>();
			//배열의 빈도를 해쉬맵에 저장
			for(int num:array) {
				countMap.put(num, countMap.getOrDefault(num, 0)+1);
			}
			//최빈값을 위한 변수
			int maxFr=-1;
			int maxCount=0;
			Vector<Integer> list = new Vector<Integer>();
			//맵을 for문 돌리면서 최빈값 찾기
			for(Map.Entry<Integer, Integer>entry:countMap.entrySet()) {
				int count=entry.getValue();
				if(count>maxCount) {
					maxFr=entry.getKey();
					maxCount=count;
				}else if(count==maxCount) {
					maxFr=-1;
				}
			}
			
			return maxFr;
		}
	}
	class Solution {
	    public int solution2(int a, int b, int c, int d) {
	        int [] arr={a,b,c,d};
	        Arrays.sort(arr);
	        //4개가 다 같을때
	        if(arr[0]==arr[3]){
	            return 1111*a;
	        }//3개 같고 1개 다를때
	        else if(arr[0]==arr[2]&&arr[0]!=arr[3]){
	            return (int) Math.pow((10*arr[0]+arr[3]), 2);
	        }else if(arr[1]==arr[3]&&arr[0]!=arr[1]) {
	        	return (int) Math.pow((10*arr[1]+arr[0]), 2);
	        }//2개 같고 2개 같을때
	        else if(arr[0]==arr[1]&&arr[2]==arr[3]&&arr[1]!=arr[2]) {
	        	return (arr[3]*arr[3]-arr[0]*arr[0]);
	        }//전부 다를때
	        else if(arr[0]!=arr[1]&&arr[1]!=arr[2]&&arr[2]!=arr[3]) {
	        	return arr[0];
	        }//나머지
	        else {
	        	if(arr[0]==arr[1]) {
	        		return arr[2]*arr[3];
	        	}else if(arr[1]==arr[2]) {
	        		return arr[0]*arr[3];
	        	}else {
	        		return arr[0]*arr[1];
	        	}
	        }
	        
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String arr="monster";
		arr.replace("m", "rn");
		ArrayList<String>list = new ArrayList<String>();
		String [] answer= new String[list.size()];
	}
	

}
