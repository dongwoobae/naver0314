package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import data.dto.StudentDto;
import db.common.MysqlConnect;

public class StudentDao {
	MysqlConnect db = new MysqlConnect();
	
	//추가
	public void insertStudent(StudentDto dto) {
		String sql="""
				insert into mystudent (name,blood,license,java,spring,html,writeday)
				values (?,?,?,?,?,?,now())
				""";
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBlood());
			pstmt.setString(3,String.valueOf(dto.getLicense()));
			pstmt.setInt(4,dto.getJava());
			pstmt.setInt(5,dto.getSpring());
			pstmt.setInt(6,dto.getHtml());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	//목록출력
	public List<StudentDto> getAllStudent(){
		List<StudentDto> list = new Vector<StudentDto>();
		StudentDto dto=null;
		String sql ="""
				select * from mystudent order by num
				""";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new StudentDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBlood(rs.getString("blood"));
				dto.setLicense(rs.getString("license").charAt(0));
				dto.setJava(rs.getInt("java"));
				dto.setSpring(rs.getInt("spring"));
				dto.setHtml(rs.getInt("html"));
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
	//디테일
	public StudentDto getData(int num) {
		StudentDto dto=null;
		String sql="""
				select * from mystudent where num=?
				""";
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();			
			
			if(rs.next()) {
				dto=new StudentDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBlood(rs.getString("blood"));
				dto.setLicense(rs.getString("license").charAt(0));
				dto.setJava(rs.getInt("java"));
				dto.setSpring(rs.getInt("spring"));
				dto.setHtml(rs.getInt("html"));
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
	public void updateStudent(StudentDto dto) {
		String sql="""
				update mystudent set name=?,blood=?,license=?,java=?,spring=?,html=?
				 where num=?
				""";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBlood());
			pstmt.setString(3, String.valueOf(dto.getLicense()));
			pstmt.setInt(4, dto.getJava());
			pstmt.setInt(5, dto.getSpring());
			pstmt.setInt(6, dto.getHtml());
			
			pstmt.setInt(7, dto.getNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
	
	public void deleteStudent(int num) {
		String sql="""
				delete from mystudent where num=?
				""";
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
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
