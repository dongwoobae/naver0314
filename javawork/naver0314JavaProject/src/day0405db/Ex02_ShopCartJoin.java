package day0405db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex02_ShopCartJoin {
	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL="jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	static final String USERNAME="root";
	static final String PASSWORD="1234";
	
	public Ex02_ShopCartJoin() {
		try {
			Class.forName(MYSQL_DRIVER);
			//System.out.println("Mysql8 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Mysql8 드라이버 오류:"+e.getMessage());
		}
	}
	
	public void writeJoin() {
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		String sql = """
//				select
//	cartnum,username,sangpum,price,color,date_format(guipday,'%Y-%m-%d') guipday
//    from shop,cart
//    where shop.shopnum=cart.shopnum
//				""";
		String sql="""
				select
	cartnum,username,sangpum,price,color,date_format(guipday,'%Y-%m-%d %H:%i') guipday
    from shop 
    inner join cart
    on shop.shopnum = cart.shopnum
				""";
		try {
			conn = DriverManager.getConnection(MYSQL_URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			//prepared 는 statement 단계에서 sql을 받아서 처리
			rs = pstmt.executeQuery();
			
			System.out.println("\t\t** 나의 장바구니 **\n");
			System.out.println("시퀀스\t이름\t상품명\t가격\t색상\t구입일");
			System.out.println("=".repeat(50));
			while(rs.next())
			{
				int cn = rs.getInt("cartnum");
				String s=rs.getString("sangpum");
				String u=rs.getString("username");
				int p = rs.getInt("price");
				String c = rs.getString("color");
				String g = rs.getString("guipday");
				
				System.out.println(cn+"\t"+u+"\t"+s+"\t"+p+"\t"+c+"\t"+g);
			}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex02_ShopCartJoin ex2 = new Ex02_ShopCartJoin();
		ex2.writeJoin();
	}

}
