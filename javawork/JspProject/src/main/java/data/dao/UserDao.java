package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.mysql.cj.xdevapi.Result;

import data.dto.UserDto;
import db.common.MysqlConnect;

public class UserDao {
MysqlConnect db = new MysqlConnect();
//추가 
public void insertUserinfo(UserDto dto) {
	String sql="""
			insert into userinformation (username,userphoto,age,addr,userclass) values(?,?,?,?,?)
			""";
	Connection conn = db.getConnection();
	PreparedStatement pstmt=null;
	try {
		pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, dto.getInfoname());
		pstmt.setString(2, dto.getUserphoto());
		pstmt.setInt(3, dto.getAge());
		pstmt.setString(4,dto.getUseraddr());
		pstmt.setString(5, dto.getUserclass());
		
		pstmt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		db.dbClose(pstmt, conn);
	}
}
//출력
public List<UserDto> getAllUserinfo(){
	List<UserDto> list = new Vector<UserDto>();
	UserDto dto=null;
	
	String sql="""
			select * from userinformation order by num desc
			""";
	Connection conn=db.getConnection();
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	try {
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			dto=new UserDto();
			
			dto.setNum(rs.getInt("num"));
			dto.setInfoname(rs.getString("username"));
			dto.setUserphoto(rs.getString("userphoto"));
			dto.setAge(rs.getInt("userage"));
			dto.setUseraddr(rs.getString("useraddr"));
			dto.setUserclass(rs.getString("userclass"));
			
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
//한사람의 데이터 가져오기
public UserDto getuserinfoData(int num) {
	UserDto dto = null;
	String sql="""
			select * from userinformation where num=?
			""";
	Connection conn=db.getConnection();
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, num);
		rs=pstmt.executeQuery();
		
		if(rs.next()) {
			dto=new UserDto();
			dto.setNum(rs.getInt("num"));
			dto.setInfoname(rs.getString("username"));
			dto.setUserphoto(rs.getString("userphoto"));
			dto.setAge(rs.getInt("userage"));
			dto.setUseraddr(rs.getString("useraddr"));
			dto.setUserclass(rs.getString("userclass"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		db.dbClose(rs, pstmt, conn);
	}
	return dto;
}


}


















