package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import data.dto.MemberDto;
import data.mapper.MemberMapperinter;

@Service
public class MemberService {
	@Autowired
	private MemberMapperinter memInter;
	
	public int getTotalCount() {
		return memInter.getTotalCount();
	}
	public int getIdCheck(String searchid) {
		return memInter.getIdCheck(searchid);
	};
	
	@Transactional
	public void insertMember(MemberDto dto) {
		 try {
		        int check = memInter.insertMember(dto);
		   
		        if (check != 1) {
		            throw new RuntimeException("Failed to insert member");
		        }
		    } catch (Exception e) {
		        // 예외 처리
		        throw new RuntimeException("Error occurred while inserting member", e);
		    }
	}
	
	public List<MemberDto> getAllMembers(){
		List<MemberDto> list = memInter.getAllMembers();
		return list;
	};
	
	public MemberDto getOneMember(int num) {
		MemberDto dto = memInter.getOneMemberByNum(num);
		return dto;
	};
	
	public MemberDto getOneMember(String myid) {
		MemberDto dto = memInter.getOneMemberById(myid);
		return dto;
	};
	
	public void updatePhoto(int num,String photo) {
		Map<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("photo", photo);
		memInter.updatePhoto(map);
	};
	
	public boolean deleteMember(String passwd,int num) {
		Map<String, Object> map = new HashMap<>();
		map.put("num", num);
		map.put("passwd", passwd);
		return memInter.deleteMember(map)==1?true:false;
	};
	
	public int updateMember(MemberDto dto) {
		return memInter.updateMember(dto);
	}
	
	public boolean isLoginCheck(String myid, String passwd) {
		return memInter.isLoginCheck(myid, passwd)==1?true:false;
	}
}
