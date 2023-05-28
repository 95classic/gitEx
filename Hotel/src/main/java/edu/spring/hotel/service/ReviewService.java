package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.ReviewVO;

public interface ReviewService {
	// 府轰 累己
	int create(ReviewVO vo);
	// 府轰 佬扁
	List<ReviewVO> read(int hotelId);
	// 府轰 荐沥
	int update(ReviewVO vo);
	// 府轰 昏力
	int delete(int reviewId, int hotelId) throws Exception;
	
} // end ReviewService
