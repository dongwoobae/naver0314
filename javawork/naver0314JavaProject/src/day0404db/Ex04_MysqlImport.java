package day0404db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex04_MysqlImport {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";

	public Ex04_MysqlImport() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql 드라이버 실패");
		}
	}
	public void writeGender() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = """
				select gender,count(*) inwon, max(score) maxscore, round(avg(score)) avgscore 
				from sawon group by gender
				""";

		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			stmt= conn.createStatement();
			rs = stmt.executeQuery(sql);

			showTitle();
			while(rs.next()) {
				String gender = rs.getString("gender");
				int inwon = rs.getInt("inwon");
				int maxscore = rs.getInt("maxscore");
				int avgscore = rs.getInt("avgscore");

				System.out.printf("%s\t%d명\t%d점\t%d점\n",gender,inwon,maxscore,avgscore);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("URL,USERNAME,PASSWORD 오류: "+e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException |NullPointerException e) {
				// TODO Auto-generated catch block
				System.out.println("rs null 연결 오류"+e.getMessage());
			}

		}


	}

	public void showTitle() {
		System.out.println("=".repeat(40));
		System.out.println("성별\t인원수\t최고점수\t평균점수");
		System.out.println("=".repeat(40));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex04_MysqlImport ex4 = new Ex04_MysqlImport();
		ex4.writeGender();
	}

}
