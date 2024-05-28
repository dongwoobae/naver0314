package day0405db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex12_Student {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex12_Student() {
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql8 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql8 드라이버 오류:"+e.getMessage());
		}
	}
	public void insertStudent(String name,int java,int html, int spring) {
		String sql ="insert into student (name,java,html,spring,testday) values (?,?,?,?,now())";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, java);
			pstmt.setInt(3, html);
			pstmt.setInt(4, spring);
			
			pstmt.execute();
			System.out.println(name+"학생 정보 추가 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException |NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void deleteStudent(String name) {
		String sql = "delete from student where name =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int n =pstmt.executeUpdate();
			if(n==0)
			{
				System.out.println("해당 학생정보 찾을 수 없음");
			}
			else
				System.out.println(name+" "+n+"명 정보 삭제 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
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
	}
	
	public void writeStudent() {
		String sql = """
				select num,name,java,html,spring,
	java+html+spring tot, round((java+html+spring)/3,1) avg,
    date_format(testday,'%Y-%m-%d %H:%i') testday
    from student
				""";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("시퀀스\t이름\tjava\thtml\tspring\t총점\t평균\t시험일");
		System.out.println("=".repeat(65));
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
			int num = rs.getInt("num");
			String name = rs.getString("name");
			int java = rs.getInt("java");
			int html = rs.getInt("html");
			int spring = rs.getInt("spring");
			int tot = rs.getInt("tot");
			double avg = rs.getDouble("avg");
			String testday = rs.getString("testday");
			
			System.out.println(num+"\t"+name+"\t"+java+"\t"+html+"\t"+spring+"\t"+tot+"\t"+avg
					+"\t"+testday);
			}System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException |NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void updateStudent(String upName,int upJava,int upHtml,int upSpring) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update student set java =?,html=?,spring=?,testday=now() where name =?";
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, upJava);
			pstmt.setInt(2, upHtml);
			pstmt.setInt(3, upSpring);
			pstmt.setString(4, upName);
			
			int n = pstmt.executeUpdate();
			if(n==0)
			{
				System.out.println("해당하는 학생 정보를 찾을수 없습니다");
			}
			else
			{
				System.out.println(upName+"님의 정보를 수정했습니다");
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
		Scanner sc = new Scanner(System.in);
		Ex12_Student ex12 = new Ex12_Student();
		int menu,java,spring,html;
		String name;
		
		Loop:
		while(true) {
		System.out.println("1. 데이터 입력\t2. 데이터 삭제\t3. 데이터 출력\t4. 데이터 수정\t5. 종료");
		try {
		menu = Integer.parseInt(sc.nextLine());
		
		switch(menu)
		{
		case 1:{
			System.out.println("이름 입력");
			name = sc.nextLine();
			System.out.println("java 점수 입력");
			java = Integer.parseInt(sc.nextLine());
			System.out.println("html 점수 입력");
			html = Integer.parseInt(sc.nextLine());
			System.out.println("spring 점수 입력");
			spring = Integer.parseInt(sc.nextLine());
			
			ex12.insertStudent(name, java, html, spring);
			System.out.println("학생정보 추가 완료");
			ex12.writeStudent();
			break;
		}
		case 2:{
			System.out.println("삭제할 학생 이름 입력");
			name = sc.nextLine();
			ex12.deleteStudent(name);
			break;
		}
		case 3:{
			ex12.writeStudent();
			break;
		}
		case 4:{
			System.out.println("점수 수정할 학생 이름 입력");
			String upName=sc.nextLine();
			System.out.println("수정할 자바점수 입력");
			int upJava = Integer.parseInt(sc.nextLine());
			System.out.println("수정할 html 점수 입력");
			int upHtml = Integer.parseInt(sc.nextLine());
			System.out.println("수정할 spring 점수 입력");
			int upSpring = Integer.parseInt(sc.nextLine());
			
			ex12.updateStudent(upName,upJava,upHtml,upSpring);
			ex12.writeStudent();
			break;
		}
		case 5:{
			System.out.println("프로그램 종료");
			break Loop;
		}
		default:{
			System.out.println("올바른 숫자 입력 요망");
			break;
		}
		}
		} catch(NumberFormatException e) {
			System.out.println("숫자 입력 요망");
		}
		
		
		}
	}

}
