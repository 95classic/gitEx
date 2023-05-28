package edu.spring.hotel.service;

import edu.spring.hotel.domain.HeartVO;

public interface HeartService {

	// 좋아요 등록
	int create(HeartVO vo) ;
	
	// 좋아요 가져오기 
	int read(HeartVO vo);
	
	// 좋아요 취소
	int delete(HeartVO vo);
	
	// 전체 좋아요 수 받아오기
//	int getHeartTotalCounts();


}
