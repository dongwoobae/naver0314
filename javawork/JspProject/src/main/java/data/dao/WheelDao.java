package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.WheelDto;
import db.common.MysqlConnect;

public class WheelDao {
	MysqlConnect db = new MysqlConnect();
	String sql;
//내가 몇개 추가해야됨
	public void insertWheel(WheelDto dto) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql="""
				insert into cycleproject.wheel (name,company,price,photo) values(?,?,?,?)
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getCompany());
			pstmt.setString(3, dto.getPrice());
			pstmt.setString(4, dto.getPhoto());
			
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}	
				
	}
	
	public List<WheelDto> getAllWheels(String sql){
		
		List <WheelDto> list=new Vector<WheelDto>();
		WheelDto dto=null;
		Connection conn=db.getConnection();		
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				dto=new WheelDto();
				dto.setName(rs.getString("name"));
				dto.setCompany(rs.getString("company"));
				dto.setPrice(rs.getString("price"));
				dto.setPhoto(rs.getString("photo"));
				
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
 		return list;
	}
}
