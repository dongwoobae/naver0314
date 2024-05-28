package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import data.dto.SawonDto;
import db.common.MysqlConnect;

public class SawonDao {
	MysqlConnect db = new MysqlConnect();
	
	//추가
	public void insertSawon(SawonDto dto) {
		String sql = """
				insert into mysawon (name,buseo,age,addr,photo,gender,birthday)
				 values(?,?,?,?,?,?,?)
				""";
		Connection conn =null;
		PreparedStatement pstmt=null;
		
		conn=db.getConnection();
		try {
			//바인딩
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBuseo());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getPhoto());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getBirthday());
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	//전체 출력
	public List<SawonDto> getAllSawons(){
		List<SawonDto> list = new Vector<SawonDto>();
		SawonDto dto =null;
		String sql="""
				select * from mysawon order by name asc
				""";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//매번 새로운 dto를 선언해서 만드는 것보다 위에서 객체생성후 재사용이 더 좋음
			while(rs.next()) {				
				dto = new SawonDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBuseo(rs.getString("buseo"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGender(rs.getString("gender"));
				dto.setBirthday(rs.getString("birthday"));
				//dto에 추가
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	//한개 반환
	public SawonDto getData(int num) {
		SawonDto dto = null;
		String sql="""
				select * from mysawon where num = ?
				""";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩 해주고 실행을 해야 오류가 안남
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto = new SawonDto();
				//dto 셋업
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBuseo(rs.getString("buseo"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGender(rs.getString("gender"));
				dto.setBirthday(rs.getString("birthday"));
				//한개만 반환할거라 list 없이 해당 dto만 반환
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	public void updateData(SawonDto dto) {
		
		String sql="""
				update mysawon set name=?,buseo=?,age=?,addr=?,photo=?,gender=?,birthday=? where num=? 
				""";
		Connection conn=null;
		PreparedStatement pstmt = null;
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBuseo());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5,dto.getPhoto());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getBirthday());
			pstmt.setInt(8, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	public void deleteSawon(int num) {
		String sql="""
			delete from mysawon where num=?
				""";
		Connection conn=null;
		PreparedStatement pstmt =null;
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//성별 분석데이터 반환
	//dto 생성 대신에 몇개 안되서 map 형식으로 받음
	//map에 object 라고 하면 int String 둘다 가능 근데 숫자도 String 으로 받을수 있으므로 그냥 String
	public List<Map<String, String>> getGenderAnalysis(){
		List<Map<String, String>> list = new Vector<Map<String,String>>();
		
		String sql="""
				select gender, count(*) count,round(avg(age),1) age from mysawon
group by gender
				""";
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String, String> map= new HashMap<String,String>();
				
				String gender=rs.getString("gender");
				String count=rs.getString("count");
				String age = rs.getString("age");
				
				//map에 넣기
				map.put("gender", gender);
				map.put("count", count);
				map.put("age", age);
				
				//list에 추가
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public List<Map<String,String>> getBuseoAnalysis(){
		List<Map<String,String>> list = new Vector<Map<String, String>>();
		String sql="""
				select buseo,count(*) count,round(avg(age),1) age from mysawon
group by buseo
				""";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
				
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Map<String,String>map=new HashMap<String, String>();
				
				String buseo=rs.getString("buseo");
				String count=rs.getString("count");
				String age=rs.getString("age");
				
				
				map.put("buseo", buseo);
				map.put("count", count);
				map.put("age", age);
				
				list.add(map);
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
