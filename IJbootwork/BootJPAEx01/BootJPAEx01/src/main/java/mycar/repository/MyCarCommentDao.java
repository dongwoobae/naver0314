package mycar.repository;

import lombok.AllArgsConstructor;
import mycar.data.MyCarCommentDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MyCarCommentDao {
    private MyCarCommentDaoInter daoInter;
    //댓글 저장
    public void insertComment(MyCarCommentDto dto){
        daoInter.save(dto);
    }
    //댓글 삭제
    public void deleteComment(int idx){
        daoInter.deleteById(idx);
    }
    //댓글들 반환
    public List<MyCarCommentDto> selectAllComments(Long num){
        return daoInter.getMyCarCommentByCarList(num);
    }
}
