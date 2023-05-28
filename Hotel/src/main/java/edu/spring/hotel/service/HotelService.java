package edu.spring.hotel.service;

import java.util.List;


import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;

// CRUD(Create, Read, Update, Delete)
public interface HotelService {
	HotelVO read(int hotelId); // 상세 검색
	
	List<HotelVO> read(PageCriteria criteria); // 전체 검색 (페이징 처리)
 	
	List<HotelVO> readOrderByPriceDesc(); // 가격별 내림차순 전체 검색
	
	List<HotelVO> readOrderByPriceAsc(); // 가격별 올림차순 전체 검색
	
	List<HotelVO> readOrderByReviewDesc(); // 리뷰순 내림차순 전체 검색
	
	int getTotalCounts(); //  전체 호텔 수 받아오기 
} // end HotelService
