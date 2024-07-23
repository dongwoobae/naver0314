package bit.repository.member;

import bit.data.member.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MemberDao {
    private MemberDaoInter daoInter;

    public MemberDto getLoginId(@Param("userid") String userid){
        return daoInter.getLoginId(userid);
    }
    public void insertMember(MemberDto member){
        daoInter.save(member);
    }
    public List<MemberDto> getAllMembers(){
        return daoInter.findAll();
    }
    public int getIdCheck (String userid){
        return daoInter.getIdCheck(userid);
    }
    public MemberDto getMemberById(@Param("userid") String userid){
        return daoInter.getLoginId(userid);
    }
}
