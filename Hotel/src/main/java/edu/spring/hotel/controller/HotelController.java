package edu.spring.hotel.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.HeartService;
import edu.spring.hotel.service.HotelService;


@Controller
@RequestMapping(value = "/main") 
public class HotelController {
	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

	@Autowired
	private HotelService hotelService;
	
	///@Autowired
	//private HeartService heartService;

	@GetMapping("/main")
	public void mainGET(Model model, Integer page, Integer numsPerPage) {
		logger.info("mainGET()");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		// 페이징 처리 
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<HotelVO> list = hotelService.read(criteria);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(hotelService.getTotalCounts());
		
	//	pageMaker.setHeartTotalCounts(heartService.getHeartTotalCounts());
		
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		
	} // end mainGET()
	
	@GetMapping("/detail")
	public void detailGET(Model model, Integer hotelId, Integer page) {
		logger.info("detailGET() 호출 : hotelId = " + hotelId);
		HotelVO vo = hotelService.read(hotelId);
		model.addAttribute("vo", vo);
		model.addAttribute("page",page);
	}// end detailGET()
	
	
	

} // end MemberController
