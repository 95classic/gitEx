package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.ReplyVO;

public interface ReplyDAO {
	// ´ñ±Û µî·Ï
	int insert(ReplyVO vo);
	// ´ñ±Û ÀüÃ¼°Ë»ö
	List<ReplyVO> selectAll(int boardId);
	// ´ñ±Û ¼öÁ¤
	int update(ReplyVO vo);
	// ´ñ±Û »èÁ¦
	int delete(int replyId);

} // end ReplyDAO
