package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.SimpleBoardDto;
import db.common.MysqlConnect;

public class SimpleBoardDao {
	MysqlConnect db = new MysqlConnect();
	
	//인서트
	public void insertBoard(SimpleBoardDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql="""
				insert into simpleboard (writer,avatar,subject,content,writeday)
				values(?,?,?,?,now())
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getAvatar());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//수정
	public void updateBoard(SimpleBoardDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql="""
				update simpleboard set writer=?, avatar=?, subject=?, content=? where num=?
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getAvatar());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, dto.getNum());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}	
	}
	
	//출력
	public List<SimpleBoardDto> getAllDatas(int start,int persize) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SimpleBoardDto dto=null;
		
		List<SimpleBoardDto> list=new Vector<SimpleBoardDto>();
		
		
		String sql="""
				select * from simpleboard order by num desc limit ?,?
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, start);
			pstmt.setInt(2, persize);
			//실행
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				dto= new SimpleBoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setAvatar(rs.getString("avatar"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setChu(rs.getInt("chu"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//list에 추가
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
	//글 전체 개수 가져오기
	public int getTotalCount() {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int n=0;
		
		String sql="""
				select count(*) from simpleboard
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				n=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return n;
	}
	//디테일 가져오기
	public SimpleBoardDto getData(int num) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SimpleBoardDto dto=null;
		
		
		String sql="""
				select * from simpleboard where num=? 
				""";
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			
			//실행
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto= new SimpleBoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setAvatar(rs.getString("avatar"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setChu(rs.getInt("chu"));
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
	public void deleteBoard(int num) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql="delete from simpleboard where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}		
	}
	
	//조회수 증가
	public void updateReadcount(int num) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		String sql="update simpleboard set readcount=readcount+1 where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}		
	}
	
	//추천수 증가
		public void updateChu(int num) {
			Connection conn=db.getConnection();
			PreparedStatement pstmt=null;
			String sql="update simpleboard set chu=chu+1 where num=?";
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setInt(1, num);
				
				pstmt.execute();			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}			
		}
}
