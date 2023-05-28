package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.ReplyVO;
import edu.spring.hotel.persistence.BoardDAO;
import edu.spring.hotel.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Transactional(value="transactionManager")
	@Override
	public int create(ReplyVO vo) {
		logger.info("댓글 create() 호출 : vo = " + vo.toString());
		replyDAO.insert(vo);
		logger.info("댓글 입력 성공!");
		boardDAO.updateReplyCnt(1, vo.getBoardId());
		logger.info("게시글 수정 성공!");
		return 1;
	}

	@Override
	public List<ReplyVO> read(int boardId) {
		logger.info("댓글 read() 호출 : boardId = " + boardId);
		return replyDAO.selectAll(boardId);
	}

	@Override
	public int update(ReplyVO vo) {
		logger.info("댓글 update() 호출 : vo = " + vo.toString());
		return replyDAO.update(vo);
	}
	
	@Transactional(value="transactionManager")
	@Override
	public int delete(int replyId, int boardId) throws Exception {
		logger.info("delete() 호출 : replyId = " + replyId);
		replyDAO.delete(replyId);
		logger.info("댓글 삭제 성공!");
		boardDAO.updateReplyCnt(-1, boardId);
		return 1;
	}
	
} // end ReplyServiceImple
