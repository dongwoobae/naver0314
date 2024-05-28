package data.service;

import data.dto.MemberDto;
import data.mapper.MemberMapperInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MemberService {
	@Autowired
	private MemberMapperInter memInter;
	
	public int getTotalCount() {
		return memInter.getTotalCount();
	}
	public MemberDto getMemberById(String myid){
		return memInter.getMemberById(myid);
	}
	public MemberDto getMemberByNum(int num){
		return memInter.getMemberByNum(num);
	}
	public List<MemberDto> getTotalMember(){
		return memInter.getTotalMember();
	}
	public void updatePhoto(String uploadphoto,int num){
		Map<String,Object> map = new HashMap<>();
		map.put("uploadphoto",uploadphoto);
		map.put("num",num);
		memInter.updatePhoto(map);
	}
	public int deleteMember(int num,String passwd){
		Map<String,Object> map = new HashMap<>();
		map.put("num",num);
		map.put("passwd",passwd);
		return memInter.deleteMember(map);
	}
	public  void  updateMember(MemberDto memberDto){
		memInter.updateMember(memberDto);
	}
	public  boolean isLoginCheck(String myid,String passwd){
		Map<String,String> map = new HashMap<>();
		map.put("myid",myid);
		map.put("passwd",passwd);
		return memInter.isLoginCheck(map) == 1;
	}
	public void insertMember(MemberDto dto){
		memInter.insertMember(dto);
	}
}
