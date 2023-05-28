package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.ReviewVO;

public interface ReviewDAO {
	// 리뷰 등록
	int insert(ReviewVO vo);
	// 리뷰 전체검색
	List<ReviewVO> select(int hotelId);
	// 리뷰 수정
	int update(ReviewVO vo);
	// 리뷰 삭제
	int delete(int reviewId);
	
} // end ReviewDAO
