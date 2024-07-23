package bit.service.member;

import bit.data.member.MemberDto;
import bit.repository.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao dao;

    public void insertMember(MemberDto member) {
        dao.insertMember(member);
    }
    public List<MemberDto> getAllMembers() {
        return dao.getAllMembers();
    }
    public MemberDto getLoginId(String userid) {
        return dao.getLoginId(userid);
    }
    public boolean getIdCheck(String userid) {
        return dao.getIdCheck(userid)==1;
    }
}
