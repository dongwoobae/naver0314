package day0404db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Ex02_OraclePerson {
	static final String ORACLE_DRIVER="oracle.jdbc.OracleDriver";
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521/xe";//강사 pc오라클을 가져오고 싶을 경우 192.168.0.59
	static final String USERNAME="angel";
	static final String PASSWORD="a1234";
		
	public void showTitle() {
		System.out.println("=".repeat(40));
		System.out.println("시퀀스\t이름\t혈액형\t나이\t입사일자");
		System.out.println("=".repeat(40));
	}
	public Ex02_OraclePerson() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이버 실패:" + e.getMessage());
		}
	}
	public void writePerson()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
//		String sql = """
//				stmt = conn.createStatement();
//				stmt = conn.createStatement();
//				""";//sql 문장이 길 경우 텍스트블록(""")을 써서 활용: JDK15부터 가능
		
		String sql = "select pnum,pname,upper(pblood),page,to_char(ipsaday,'yyyy-mm-dd') ipsaday from person";
		try {
			conn = DriverManager.getConnection(ORACLE_URL, USERNAME, PASSWORD);
			System.out.println("오라클 연결 성공");
			
			showTitle();
			
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				String pnum = rs.getString("pnum");
				String pname = rs.getString("pname");
				String pblood = rs.getString("upper(pblood)");//열이름이 잘못되서 안가져와졌음. 열이름을 pblood로 바꾸던지
				//아니면 해당 열이름을 그대로 가져오던지 해야함
				int page = rs.getInt("page");
				String ipsaday =rs.getString("ipsaday");
				
				System.out.printf("%s\t%s\t%s형\t%d세\t%s\n",pnum,pname,pblood,page,ipsaday);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 연결실패: "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_OraclePerson ex2= new Ex02_OraclePerson();
		ex2.writePerson();
	}

}
