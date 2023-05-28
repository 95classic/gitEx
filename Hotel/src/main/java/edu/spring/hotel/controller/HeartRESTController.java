package edu.spring.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.hotel.domain.HeartVO;
import edu.spring.hotel.service.HeartService;

@RestController
@RequestMapping(value="/main/heart")
public class HeartRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(HeartRESTController.class);
    @Autowired
    private HeartService heartService;
    

    @PostMapping
    @ResponseBody
    public ResponseEntity<Integer> heartPOST(@RequestBody HeartVO vo) {
    	logger.info("heartPOST() 호출: vo = " + vo.toString());
    	// 프론트 가져온 데이터 
    	int heartNo = vo.getHeartNo();
    	int hotelId = vo.getHotelId();
    	String memberId = vo.getMemberId();
   
    	
    	// vo에 데이터 저장하고 백에서 프론트로 
    	HeartVO heart = new HeartVO();
    	heart.setHeartNo(heartNo);
    	heart.setHotelId(hotelId);
    	heart.setMemberId(memberId);
    	
    	//좋아요 여부 확인
    	int count = heartService.read(heart);
    	logger.info("좋아요 여부 들어오나요");
    	int result =0;
    	
    	if(count == 0) {
    		heartService.create(heart);
    		result =1;
    		
    	} else {
    		 heartService.delete(heart);
    		 result = 0;
    	}
    	return new ResponseEntity<Integer>(result, HttpStatus.OK);
    } // end heartPOST
}