package day0404db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01_MysqlSawon {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex01_MysqlSawon() {
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql8 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql8 드라이버 오류:"+e.getMessage());
		}
		
	}
	public void showTitle() {
		System.out.println("=".repeat(40));
		System.out.println("시퀀스\t이름\t성별\t부서\t점수");
		System.out.println("=".repeat(40));		
	}
	public void writeSawon() {
		
		Connection conn = null;
		Statement stmt=null;
		ResultSet rs=null;//select 문일 경우에만 필요한 클래스
		String sql="select * from sawon order by num";
		try {			
			//URL이 맞으면 connection 을 얻는다
			conn = DriverManager.getConnection(MYSQL_URL,USERNAME,PASSWORD);
			System.out.println("Mysql 서버에 연결성공");
			
			showTitle();
			
			stmt=conn.createStatement();//sql을 실행하기 위한 statement 얻기
			rs=stmt.executeQuery(sql);//select 문일 경우 무조건 excuteQuery로 실행
			while(rs.next())//rs.next()는 다음 레코드로 이동하면서 true 반환, 이동할 데이터가 없으면 false 반환
			{
				//데이터를 가져올때는 컬럼번호 또는 컬럼명으로 가져오면 됨
				
				//컬럼번호로 가져오기(컬럼에 변동이있을경우 다른값 가져올수도있음)
//				int num = rs.getInt(1);
//				String name = rs.getString(2);
//				int score = rs.getInt(3);
//				String gender = rs.getString(4);
//				String buseo = rs.getString(5);
				
				//컬럼명으로 가져오기(컬럼에 변동이 있어도 괜찮음)
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int score = rs.getInt("score");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				
				
				System.out.printf("%d\t%s\t%s\t%s\t%d\n",num,name,gender,buseo,score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("URL,USERNAME,PASSWORD 확인"+e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01_MysqlSawon ex1= new Ex01_MysqlSawon();
		ex1.writeSawon();
	}

}
