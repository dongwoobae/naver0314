package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.GuestDto;
import data.dto.StudentDto;
import db.common.MysqlConnect;

public class GuestDao {
	MysqlConnect db=new MysqlConnect();
	
	//추가 
	public void insertGuest(GuestDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		String sql="""
				insert into guest (nickname,avatar,content,writeday) values (?,?,?,now());
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getAvatar());
			pstmt.setString(3, dto.getContent());
			
			pstmt.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//출력
	public List<GuestDto> getAllGuest(){
		List<GuestDto> list = new Vector<>();
		GuestDto dto=null;
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="""
				select * from guest order by num desc
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				dto=new GuestDto();
				dto.setNum(rs.getInt("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setAvatar(rs.getString("avatar"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
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
	//검색
		public List<GuestDto> getSearchGuest(String searchword){
			List<GuestDto> list = new Vector<>();
			GuestDto dto=null;
			Connection conn=db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql="""
					select * from guest where nickname like ?
					""";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, "%"+searchword+"%");
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					dto=new GuestDto();
					dto.setNum(rs.getInt("num"));
					dto.setNickname(rs.getString("nickname"));
					dto.setAvatar(rs.getString("avatar"));
					dto.setContent(rs.getString("content"));
					dto.setWriteday(rs.getTimestamp("writeday"));
					
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
		
	//상세보기
	public GuestDto getData(int num) {
		GuestDto dto=null;
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="""
				select * from guest where num=?
				""";
		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new GuestDto();
				dto.setNum(rs.getInt("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setAvatar(rs.getString("avatar"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
	}
	
	//삭제
	public void deleteData(int num) {
		GuestDto dto=null;
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		String sql="""
				delete from guest where num=?
				""";
		try {			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose( pstmt, conn);
		}
	}
	
	//닉네임과 콘텐트만 update
	public void updateGuest(GuestDto dto) {
		String sql="""
				update guest set nickname=?, content=?
				 where num=?
				""";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNickname());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
}

