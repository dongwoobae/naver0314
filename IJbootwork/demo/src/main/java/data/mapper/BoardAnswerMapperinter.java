package data.mapper;

import data.dto.AnsPhotoDto;
import data.dto.BoardAnswerDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardAnswerMapperinter {
    @Insert("""
insert into boardanswer (num,writer,myid,content,writeday) values (#{num},#{writer},#{myid},#{content},now())
""")
    public void insertAnswer(BoardAnswerDto dto);
    @Select("select * from boardanswer where num=#{num} order by aidx desc")
    public List<BoardAnswerDto>  selectAllAnswer(int num);
    @Delete("delete from boardanswer where aidx=#{adix}")
    public void deleteAnswer(int aidx);
    @Select("SELECT b.myid,m.photo FROM boardanswer b INNER JOIN memberdb m ON b.myid=m.myid where b.num=#{num}")
    public List<AnsPhotoDto> selectAnswer(int num);
}