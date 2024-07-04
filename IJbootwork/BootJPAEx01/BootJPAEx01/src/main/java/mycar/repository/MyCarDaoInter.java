package mycar.repository;

import mycar.data.MyCarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long> {
    //사진을 선택 안했을 경우 사진하고 구입날짜는 빼고 수정
    //@Query: repository에 원하는 쿼리를 작성하게 해주는 어노테이션
    //naticeQuery: JPA에서 지정한 규칙을 모두 무시할 수 있는 속성
    @Query(value = """
                    update mycar set carname:carname,carprice:carprice,
                                     carcolor:carcolor where num=:num
            """, nativeQuery = true)
    @Modifying//@Modifying은 insert,update,delete 뿐 아니라 DDL 구문을 사용할 때도 표기 필수
    @Transactional//update, delete를 할때 표기를 필수
    public void updateMycarNoPhoto(@Param("num") Long num,
                                   @Param("carname") String carname,
                                   @Param("carprice") int carprice,
                                   @Param("carcolor") String carcolor);

    //파라미터를 dto로 받은 경우
    @Query(value = """
                    update mycar set carname=:#{#dto.carname},carprice=:#{#dto.carprice},
                                     carcolor=:#{#dto.carcolor} where num=:#{#dto.num}
            """, nativeQuery = true)
    @Modifying
    @Transactional
    public void updateMycarNoPhoto(@Param("dto") MyCarDto dto);
}
