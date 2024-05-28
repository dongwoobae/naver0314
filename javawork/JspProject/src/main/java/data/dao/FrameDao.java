package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.FrameDto;
import db.common.MysqlConnect;

public class FrameDao {
	MysqlConnect db = new MysqlConnect();
	String sql;
//내가 몇개 추가해야됨
	public void insertFrame(FrameDto dto) {
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql="""
				insert into cycleproject.frame (name,company,price,photo,color) values(?,?,?,?,?)
				""";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getCompany());
			pstmt.setString(3, dto.getPrice());
			pstmt.setString(4, dto.getPhoto());
			pstmt.setString(5, dto.getColor());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}	
				
	}
	
	public List<FrameDto> getAllFrames(String sql){
		
		List <FrameDto> list=new Vector<FrameDto>();
		FrameDto dto=null;
		Connection conn=db.getConnection();		
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				dto=new FrameDto();
				dto.setName(rs.getString("name"));
				dto.setCompany(rs.getString("company"));
				dto.setPrice(rs.getString("price"));
				dto.setPhoto(rs.getString("photo"));
				dto.setColor(rs.getString("color"));
				
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
