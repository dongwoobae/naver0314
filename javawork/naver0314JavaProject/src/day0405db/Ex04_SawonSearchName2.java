package day0405db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Ex04_SawonSearchName2 {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex04_SawonSearchName2()  {
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql8 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql8 드라이버 오류:"+e.getMessage());
		}
	}
	
	public void searchSawon(String searchName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon where name like?";
		//System.out.println(sql);
		boolean find = false;
		
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			//? 갯수만큼 바인딩
			pstmt.setString(1, "%"+searchName+"%");
			//?에 값을 다 넣은 후 실행
			rs=pstmt.executeQuery();
			
			
			System.out.println("** "+searchName+" 검색결과 **");
			System.out.println("=".repeat(40));
			System.out.println("시퀀스\t이름\t성별\t부서\t점수");
			System.out.println("=".repeat(40));	
			
			while(rs.next())
			{
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int score = rs.getInt("score");
				
				System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+score);
				find=true;
			}
			if(!find)
				System.out.println(searchName+"을 포함하는 사원은 없습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();	
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_SawonSearchName2 ex3 = new Ex04_SawonSearchName2();
		Scanner sc = new Scanner(System.in);
		String searchname="";
		while(true)
		{
			System.out.println("검색할 이름을 입력해주세요. (종료 x)");
			searchname = sc.nextLine();
			if(searchname.equalsIgnoreCase("x")) {
				System.out.println("종료");
				break;
			}
			ex3.searchSawon(searchname);
			System.out.println();
		}
	}

}
