package day0320;

public class Ex07_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {10,20,30,40,50,-10,-20,-30,-40,-50};
		//System.out.println(data.length);
		int max,min;
		max=min=data[0];
		
		for(int i=1;i<data.length;i++)
		{
			if(max<data[i])
				max=data[i];
			if(min>data[i])
				min=data[i];
		}
		System.out.println("최대값: "+max);
		
		System.out.println("최소값: "+min);
		
		int pcnt=0,mcnt=0;
		//배열의 양수개수와 음수개수를 구하여서 출력해보시오
		for(int i=0;i<data.length;i++)
		{
			if(data[i]>0)
				pcnt++;
			else if(data[i]<0)
				mcnt++;
		}
		System.out.println("배열의 양수 개수: "+pcnt);
		System.out.println("배열의 음수 개수: "+mcnt);
		
		
		
		
		
		
		
		
		
	}
	
	

}
