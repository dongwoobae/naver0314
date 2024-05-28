package day0405db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0404db.Ex01_MysqlSawon;

public class Ex10_SawonUpdate2 {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex10_SawonUpdate2() {
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql8 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql8 드라이버 오류:"+e.getMessage());
		}
	}
	
	public void updateSawon() {
		Scanner sc = new Scanner(System.in);
		Ex01_MysqlSawon ex1 = new Ex01_MysqlSawon();
		ex1.writeSawon();
		System.out.println("=".repeat(40));
		
		String updateName,updateBuseo;
		int updateScore;
		
		System.out.println("수정할 사람의 이름은?");
		updateName = sc.nextLine();
		System.out.println("업데이트할 점수 입력");
		updateScore = Integer.parseInt(sc.nextLine());
		System.out.println("업데이트할 부서명 입력");
		updateBuseo = sc.nextLine();
		
		String sql = "update sawon set score=?,buseo=? where name=?";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, updateScore);
			pstmt.setString(2, updateBuseo);
			pstmt.setString(3, updateName);
			
			
			int n =pstmt.executeUpdate();
			if(n==0)
			{
				System.out.println("해당하는 사람이 없습니다");
			}
			else {
				System.out.println(updateName+"님의 정보를 변경했습니다");
				ex1.writeSawon();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException |NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex10_SawonUpdate2 ex9 = new Ex10_SawonUpdate2();
		ex9.updateSawon();
	}

}
