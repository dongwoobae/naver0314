package data.mapper;

import data.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface MemberMapperInter {
	public int getTotalCount();
	public MemberDto getMemberById(String myid);
	public MemberDto getMemberByNum(int num);
	public List<MemberDto> getTotalMember();
	public void updatePhoto(Map<String, Object> map);
	public int deleteMember(Map<String, Object> map);
	public  void  updateMember(MemberDto memberDto);
	public int isLoginCheck(Map<String,String> map);
	public void insertMember(MemberDto memberDto);
}

