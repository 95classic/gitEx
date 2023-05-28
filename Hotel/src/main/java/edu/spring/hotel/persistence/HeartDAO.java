package edu.spring.hotel.persistence;

import edu.spring.hotel.domain.HeartVO;

public interface HeartDAO {
	// 좋아요 추가
	int insert(HeartVO vo);
	
	// 좋아요 취소 
	int delete(HeartVO vo);
	
	// 좋아요 보여주기 
	int select(HeartVO vo);
	
	// 좋아요 총 갯수 가져오기
	int getHeartTotalCounts();
	// 하트 번호 조회 (hotelId와 memberId)로
//	int getHeartNOByHotelIdAndMemberId(int hotelId, String memberId);
	

} // end HeartDAO
