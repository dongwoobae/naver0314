package day0321;

public class Ex05_ArrayAgeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] memberages = {12,8,15,16,18,20,21,25,29,35,33,37,41,51,59,55,50,40,45,58};
		//System.out.println(memberages.length);
		int []agecount=new int[6];
		
		System.out.println("*** 연령별 인원수 출력 ***");
		
		for(int i=0;i<memberages.length;i++)
		{
			int a = memberages[i]/10;
			agecount[a]++;
		}
		System.out.printf("10세 미만: %d명\n",agecount[0]);
		for(int i=0;i<agecount.length-1;i++)
		{
		System.out.printf("%d0대: %d명\n",i+1,agecount[i+1]);
		}
		
	}

}
