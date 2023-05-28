package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.ReviewVO;

@Repository
public class ReviewDAOImple implements ReviewDAO {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReviewDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.ReviewMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReviewVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ReviewVO> select(int hotelId) {
		logger.info("select() 호출 : hotelId = " + hotelId);
		return sqlSession.selectList(NAMESPACE + ".select_all", hotelId);
	}

	@Override
	public int update(ReviewVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int reviewId) {
		logger.info("delete() 호출 : reviewId = " + reviewId);
		return sqlSession.delete(NAMESPACE + ".delete", reviewId);
	}

} // end ReviewDAOImple
