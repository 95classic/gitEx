package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReplyVO vo) {
		logger.info("insert() 호출 : vo = " + vo);
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ReplyVO> selectAll(int boardId) {
		logger.info("selectAll() 호출 : boardId = " + boardId);
		return sqlSession.selectList(NAMESPACE + ".select_all", boardId);
	}

	@Override
	public int update(ReplyVO vo) {
		logger.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int replyId) {
		logger.info("delete() 호출");
		return sqlSession.delete(NAMESPACE + ".delete", replyId);
	}

} // end ReplyDAOImple
