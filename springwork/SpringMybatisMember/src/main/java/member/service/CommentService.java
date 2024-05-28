package member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import member.dao.CommentDao;
import member.dto.CommentDto;

@Service
@AllArgsConstructor
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	
	public int selectTotalCounts() {
		return commentDao.selectTotalCounts();
	}
	public List<CommentDto> selectAllComments(){
		return commentDao.selectAllComments();
	}
	public void insertComment(CommentDto dto) {
		commentDao.insertComment(dto);
	}
}
