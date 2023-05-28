package edu.spring.hotel.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.spring.hotel.domain.ReplyVO;
import edu.spring.hotel.domain.ReviewVO;
import edu.spring.hotel.service.ReplyService;
import edu.spring.hotel.service.ReviewService;



// * RESTful url과 의미
// /replies (POST) : 리뷰 추가(insert)
// /replies/all/숫자 (GET) : 해당 호텔 번호(hotelId)의 모든 댓글 검색(select)
// /replies/숫자 (PUT) : 해당 리뷰 번호(reviewId)의 내용을 수정(update)
// /replies/숫자 (DELETE) : 해당 리뷰 번호(reviewId)의 리뷰를 삭제(delete)

@RestController
@RequestMapping(value="main/reviews")
public class ReviewRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(ReviewRESTController.class);
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping // POST : 리뷰 입력
	public ResponseEntity<Integer> createReview(@RequestBody ReviewVO vo) {
		// @RequestBody
		// - 클라이언트에서 전송받은 json 데이터를
		//	 자바 객체로 변환해주는 annotation
		logger.info("createReview() 호출 : vo = " + vo.toString());
		
		// ResponseEntity<T> : Rest 방식에서 데이터를 리턴할 때 쓰이는 객체
		// - 데이터 HttpStatus를 전송
		// - <T> : 보내고자 하는 데이터 타입
		int result = 0;
		try {
			result = reviewService.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end createReview()
	
	@GetMapping("/all/{hotelId}") // GET : 리뷰 선택(all)
	public ResponseEntity<List<ReviewVO>> readReviews(
			@PathVariable("hotelId") int hotelId) {
			// @PathVariable("hotelId") : /all/{hotelId} 값을 설정된 변수에 저장
		logger.info("readReviews() 호출 : hotelId = " + hotelId);
		List<ReviewVO> list = reviewService.read(hotelId);
		return new ResponseEntity<List<ReviewVO>>(list, HttpStatus.OK);
	} // end readReviews()
	
	@PutMapping("/{reviewId}") // PUT : 리뷰 수정
	public ResponseEntity<Integer> updateReview(
			@PathVariable("reviewId") int reviewId,
			@RequestBody ReviewVO vo
			) {
		int result = reviewService.update(vo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end updateReview()
	
	@DeleteMapping("/{reviewId}")
	public ResponseEntity<Integer> deleteReview(
			@PathVariable("reviewId") int reviewId,
			@RequestBody int hotelId) {
		logger.info("reviewId = " + hotelId);
		
		int result = 0;
		try {
			result = reviewService.delete(reviewId, hotelId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end deleteReview()
	
} // end ReviewRESTController
