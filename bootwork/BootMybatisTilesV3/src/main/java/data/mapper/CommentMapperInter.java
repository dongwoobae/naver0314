package data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import data.dto.CommentDto;

@Mapper
public interface CommentMapperInter {
@Insert("insert into comment (userid, passwd, content, writeday, mynum) values(#{userid},#{passwd},#{content},now(),#{mynum})")
public void insertComment(CommentDto dto);

@Delete("delete from comment where mynum=#{mynum} and passwd=#{passwd}")
public int deleteComment(Map<String, Object> map);
@Select("select * from comment where mynum=#{mynum}")
public List<CommentDto> selectComments(int mynum);
}
