package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class Ex17_MunjeAnswer {

	static final String FILENAME ="C:\\naver03\\score.txt";
	static public void scoreRead() throws IOException
	{
		int score,sum=0,count=0;
		double avg=0;
		FileReader fr= null;
		BufferedReader br = null;
		
		try {
			fr=new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while(true) 
			{
				String s = br.readLine();
				if(s==null)//읽을 데이터가 더이상 없을경우 while 종료
				{
					break;
				}
				try {
					score=Integer.parseInt(s);
					count++;//score가 int인것만 count. 내가 한 방식은 전부 count 후 error 뺌.
					sum+=score;
				}catch(NumberFormatException e) {
					
				}
			}
			avg = (double)sum/count;
			System.out.println("점수 개수 :"+count);
			System.out.println("총점 :"+sum);
			//소수점 이하 2자리까지 출력
			NumberFormat nf = NumberFormat.getInstance();
			nf.setMaximumFractionDigits(2);
			System.out.println("평균 : "+nf.format(avg));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없어요"+e.getMessage());
		} finally {
			br.close();
			fr.close();
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			scoreRead();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
