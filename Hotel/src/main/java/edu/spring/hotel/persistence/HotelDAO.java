package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;


public interface HotelDAO {
	
	
	HotelVO select(int hotelId); // 호텔 상세 검색
	
	List<HotelVO> select(); // 호텔 전제 검색
	
	List<HotelVO> selectAllByPriceDesc(); // 호텔 가격 내림차순 정렬 전체검색
	
	List<HotelVO> selectAllByPriceAsc(); // 호텔 가격 오름차순 정렬 전체검색
	
	List<HotelVO> selectAllByReviewDesc(); // 호텔 리뷰 많은 순 검색
	
	List<HotelVO> select(PageCriteria criteria); // 호텔 페이징 처리를 위한 전체 검색

	int getTotalCounts(); // 전체 호텔 수 불러오기
	
	int updateReviewCnt(int amount, int hotelId); // 리뷰 수정, 삭제 시 리뷰 개수 수정
	
}
