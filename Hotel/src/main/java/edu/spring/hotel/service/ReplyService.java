package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.ReplyVO;

//CRUD(Create, Read, Update, Delete)

public interface ReplyService {
	// ´ñ±Û ÀÛ¼º
	int create(ReplyVO vo);
	// ´ñ±Û ÀÐ±â
	List<ReplyVO> read(int boardId);
	// ´ñ±Û ¼öÁ¤
	int update(ReplyVO vo);
	// ´ñ±Û »èÁ¦
	int delete(int replyId, int boardId) throws Exception;
}
