package data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import data.dto.MemberDto;

@Mapper
public interface MemberMapperinter {
	@Select("select count(*) from memberdb")
	public int getTotalCount();
	@Select("select count(*) from memberdb where myid=#{searchid}")
	public int getIdCheck(String searchid);
	@Insert("""
			insert into memberdb (name,myid,passwd,addr,hp,email,photo,birthday,gaipday)
		values (#{name},#{myid},#{passwd},#{addr},#{hp},#{email},#{photo},#{birthday},now())
			""")
	public int insertMember(MemberDto dto);
	
	@Select("select * from memberdb order by num")
	public List<MemberDto> getAllMembers();
	
	@Select("select * from memberdb where num=#{num}")
	public MemberDto getOneMemberByNum(int num);
	@Select("select * from memberdb where myid=#{myid}")
	public MemberDto getOneMemberById(String myid);
	@Update("update memberdb set photo=#{photo} where num=#{num}")
	public void updatePhoto(Map<String, Object> map);
	@Delete("delete from memberdb where num=#{num} and passwd=#{passwd}")
	public int deleteMember(Map<String,Object> map);
	@Update("""
			update memberdb set addr=#{addr},hp=#{hp},email=#{email},birthday=#{birthday}
		where num=#{num}
			""" )
	public int updateMember(MemberDto dto);
	@Select("select count(*) from memberdb where myid=#{myid} and passwd=#{passwd}")
	public int isLoginCheck(String myid, String passwd);
}
