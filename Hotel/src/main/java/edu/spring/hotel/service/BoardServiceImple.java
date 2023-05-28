package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.BoardVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.BoardDAO;

@Service
public class BoardServiceImple implements BoardService {
	private static Logger logger =
			LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardDAO dao;
	
	
	@Override
	public int create(BoardVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<BoardVO> read(PageCriteria criteria) {
		logger.info("read() 호출");
		logger.info("start : " + criteria.getStart());
		logger.info("end : " + criteria.getEnd());
		return dao.select(criteria);
	}
	
	@Override
	public BoardVO read(int boardId) {
		logger.info("read() 호출 : boardId = " + boardId);
		return dao.select(boardId);
	}

	@Override
	public int update(BoardVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return dao.update(vo);
	}

	@Override
	public int delete(int boardId) {
		logger.info("delete() 호출 : boardId = " + boardId);
		return dao.delete(boardId);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	}
	
} // end BoardServiceImple
