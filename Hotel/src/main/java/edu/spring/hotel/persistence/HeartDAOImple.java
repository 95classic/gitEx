package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.HeartVO;
import edu.spring.hotel.domain.HotelVO;

@Repository
public class HeartDAOImple implements HeartDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(HeartDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.HeartMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(HeartVO vo) {
		logger.info("insert()호출 : vo = " + vo);
		return sqlSession.insert(NAMESPACE + ".insert_heart", vo);
	} // end insertHeart


	@Override
	public int delete(HeartVO vo) {
		logger.info("delete()호출 : vo = " + vo);
		return sqlSession.delete(NAMESPACE + ".delete_heart", vo);
	}


	@Override
	public int select(HeartVO vo) {
		logger.info("selelct()호출 : vo = " + vo);
		return sqlSession.selectOne(NAMESPACE + ".get_hotel_heart", vo);
	}


	@Override
	public int getHeartTotalCounts() {
		logger.info("getHeartTotalcount()호출");
		return sqlSession.selectOne(NAMESPACE + ".hotel_heart_cnt");
	
	}


	
	

//	@Override
//	public int getHeartNOByHotelIdAndMemberId(int hotelId, String memberId) {
//		logger.info("getHeartNOByHotelIdAndMemberId()호출" );
//		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("hotelId", hotelId);
//		paramMap.put("memberId", memberId);
//		return sqlSession.selectOne(NAMESPACE + ".select_heart",paramMap);
//	}

	

	
} // end HeartDAOImple
