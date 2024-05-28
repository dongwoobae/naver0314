package day0405db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import prc.Max_Frequency;

public class Ex01_MysqlSawonGroup {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex01_MysqlSawonGroup() {
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql8 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql8 드라이버 오류:"+e.getMessage());
		}
	}
	public void writeSawonGroup() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = """
				select buseo,count(*) inwon, max(score) maxscore, ceiling(avg(score)) avgscore
from sawon group by buseo
				""";
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			System.out.println("\t**부서별 현황**\n");
			System.out.println("부서명\t인원수\t최고점수\t평균점수");
			System.out.println("=".repeat(30));
			
			while(rs.next())
			{
				String buseo = rs.getString("buseo");
				int inwon = rs.getInt("inwon");
				int maxscore = rs.getInt("maxscore");
				int avgscore = rs.getInt("avgscore");
				
				System.out.printf("%s\t%d명\t%d점\t%d점\n",buseo,inwon,maxscore,avgscore);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException |NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01_MysqlSawonGroup ex1 = new Ex01_MysqlSawonGroup();
		ex1.writeSawonGroup();
	}

}
