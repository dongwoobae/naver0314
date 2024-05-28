package data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import data.dto.ReBoardDto;

@Mapper
public interface ReBoardMapperinter {
	
	public int getMaxNum(); //mapper.xml 파일의 id를 메소드 이름으로 주면 자동호출 됨
	public void updateRestep(Map<String, Integer> map); //regroup, restep이 들어있어야됨
	public void insertBoard(ReBoardDto dto);
	public int getTotalCount();
	public List<ReBoardDto> getPagingList(Map<String, Integer> map);
	public void updateReadcount(int num);
	public ReBoardDto getData(int num);
}
