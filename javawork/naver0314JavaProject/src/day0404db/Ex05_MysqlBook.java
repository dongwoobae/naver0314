package day0404db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex05_MysqlBook {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/opentutorials?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex05_MysqlBook() {
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("mysql 드라이버 오류");
		}
	}
	
	public void writeBook() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from topic";
		
		try {
			conn=DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
			//mysql_url만 넣고 username,password를 안써서 오류가 남
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			showTitle();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String created = rs.getString("created");
				String author = rs.getString("author");
				String profile = rs.getString("profile");
				
				System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n",id,title,description,
						created,author,profile);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("URL,ID,Password 확인: "+e.getMessage());
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
	
	public void showTitle() {
		System.out.println("-".repeat(60));		
		System.out.println("번호\t제목\t내용\t쓰여진 날\t저자\t프로필");
		System.out.println("-".repeat(60));

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex05_MysqlBook ex5 = new Ex05_MysqlBook();
		ex5.writeBook();
	}

}
