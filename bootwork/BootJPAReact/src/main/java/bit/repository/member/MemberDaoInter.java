package bit.repository.member;

import bit.data.member.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberDaoInter extends JpaRepository<MemberDto, Long> {
    @Query(value = "select * from member where userid=:userid",nativeQuery = true)
    public MemberDto getLoginId(@Param("userid") String userid);
    @Query(value = "select count(*) from  member where userid=:userid",nativeQuery = true)
    public int getIdCheck(@Param("userid") String userid);
}
