package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.ReviewVO;
import edu.spring.hotel.persistence.HotelDAO;
import edu.spring.hotel.persistence.ReviewDAO;

@Service
public class ReviewServiceImple implements ReviewService {
	private static final Logger logger =
			LoggerFactory.getLogger(ReviewServiceImple.class);
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private HotelDAO hotelDAO;

	@Transactional(value="transactionManager")
	@Override
	public int create(ReviewVO vo) {
		logger.info("리뷰 create() 호출 : vo = " + vo.toString());
		reviewDAO.insert(vo);
		logger.info("리뷰 입력 성공!");
		hotelDAO.updateReviewCnt(1, vo.getHotelId());
		logger.info("호텔 정보 수정 성공!");
		return 1;
	}

	@Override
	public List<ReviewVO> read(int hotelId) {
		logger.info("리뷰 read() 호출 : hotelId = " + hotelId);
		return reviewDAO.select(hotelId);
	}

	@Override
	public int update(ReviewVO vo) {
		logger.info("리뷰 update() 호출 : vo = " + vo.toString());
		return reviewDAO.update(vo);
	}

	@Transactional(value="transactionManager")
	@Override
	public int delete(int reviewId, int hotelId) throws Exception {
		logger.info("리뷰 delete() 호출");
		reviewDAO.delete(reviewId);
		logger.info("리뷰 삭제 성공!");
		hotelDAO.updateReviewCnt(-1, hotelId);
		return 1;
	}
	
	
	
} // end ReviewServiceImple
