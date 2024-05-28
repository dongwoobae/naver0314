package member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import member.dao.MemberDao;
import member.dto.MemberDto;

@Service
@AllArgsConstructor
public class MemberService {
	//@Autowired
	private MemberDao memberDao;
	
	public int getTotalCount() {
		return memberDao.getTotalCount();
	}
	public int getSearchId(String searchid) {
		return memberDao.getSearchId(searchid);
	}
	public void insertMember(MemberDto dto) {
		memberDao.insertMember(dto);
	}
	public List<MemberDto> getAllMembers(){
		return memberDao.getAllMembers();
	}
	public MemberDto getOneMember(String myid) {
		return memberDao.getOneMember(myid);
	}
	public void deleteMember(int num) {
		memberDao.deleteMember(num);
	}
	public void updateMember(MemberDto dto) {
		memberDao.updateMember(dto);
	}
	public void updatePhoto(String myid,String photo) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("myid",myid);
		map.put("photo", photo);
		memberDao.updatePhoto(map);
	}
	public boolean equalPassCheck(String passwd,int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("passwd", passwd);
		map.put("num", num);
		return memberDao.equalPassCheck(map);
	}
}
