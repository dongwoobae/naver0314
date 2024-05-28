package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import data.dto.CommentDto;
import data.mapper.CommentMapperInter;


@Service
public class CommentService {
	@Autowired
private CommentMapperInter comInter;
	
	@Transactional
	public void insertComment(CommentDto dto) {
		comInter.insertComment(dto);
	}
	
	public int deleteComment(String passwd,int num) {
		Map<String, Object> map =new HashMap<>();
		map.put("mynum", num);
		map.put("passwd", passwd);
		return comInter.deleteComment(map);
	};
	
	public List<CommentDto> selectComments(int mynum){
		List<CommentDto> list=comInter.selectComments(mynum);
		return list;
	};
}
