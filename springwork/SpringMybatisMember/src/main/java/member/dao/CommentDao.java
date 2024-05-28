package member.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.CommentDto;

@Repository
@RequiredArgsConstructor
public class CommentDao {
	@NonNull
	private SqlSession session;
	private String namespace="member.dao.CommentDao.";
	
	public int selectTotalCounts() {
		return session.selectOne(namespace+"selectTotalCounts");
	}
	public List<CommentDto> selectAllComments(){		
		return session.selectList(namespace+"selectAllComments");		
	}
	public void insertComment(CommentDto dto) {
		session.insert(namespace+"insertComment",dto);
	}
}
