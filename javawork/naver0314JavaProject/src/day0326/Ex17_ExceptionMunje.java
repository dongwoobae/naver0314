package day0326;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * score.txt를 읽어서 총 개수와 총점,평균을 구하시오
 * 단, 점수에 문자가 있는 경우 개수에서 제외하고 총점에서도 제외하고 출력이 되도록 하기 
 */
public class Ex17_ExceptionMunje {

	static final String FILENAME ="C:\\naver03\\score.txt";
	static void fileRead()
	{
		BufferedReader br = null;
		FileReader fr = null;
		int sum=0,count=0,error=0;
		try {
			fr=new FileReader(FILENAME);
			System.out.println("파일을 읽습니다");
			br = new BufferedReader(fr);
			
			while(true)
			{
				String line = br.readLine();
				if(line==null)
					break;
				try
				{
					count++;
					sum+=Integer.parseInt(line);
				} catch(NumberFormatException e)
				{
					error ++;
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 존재하지 않습니다");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			double avg = (double)sum/(count-error);
			
			System.out.println("총 개수: "+(count-error));
			System.out.println("총점: "+sum);
			System.out.println("평균: "+avg);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileRead();
	}

}
