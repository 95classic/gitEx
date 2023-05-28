package edu.spring.hotel.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.service.MemberService;

@Controller
@RequestMapping(value = "/main/member") // url : /hotel/member렇게 해놓으면 전부 member 하위로 만들어짐
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@GetMapping("/register")
	public void registerGET() {
		logger.info("registerGET()");
	} // end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(MemberVO vo, RedirectAttributes reAttr) {
		logger.info("registerPOST() 호출");
		logger.info(vo.toString());
		int result = memberService.create(vo);
		logger.info(result + "행 삽입");
		if (result == 1) {
			reAttr.addFlashAttribute("result", "registerSuccess");
			return "redirect:/main/main";
		} else {
			return "redirect:/main/member/register";
		}
	} // end registerPOST() 
	
	@GetMapping("/idCheck")
	public void idCheckGET() {
	
	}// end idcheckGET()
	
	@ResponseBody
	@PostMapping("/idCheck")
	public int idcheckPOST(MemberVO vo) {
	    logger.info("idcheckPOST() 호출");
	    logger.info(vo.toString());
	   
	    int result = memberService.idcheck(vo);
	    logger.info("여기까지는 실행");
	    return result;

	} // end idcheckPOST() 아이디 중복확인
	
	// 로그인 메소드
	@GetMapping("/login")
	public void loginGET() {
		logger.info("loginGET() 호출");	
	} // end loginGET()

	// 로그인 메소드
	@PostMapping("/login")
	public String loginPOST(MemberVO vo, RedirectAttributes reAttr, HttpSession session, HttpServletRequest request) throws Exception {
		logger.info("loginPOST() 호출");

		vo = memberService.login(vo);
		
		// targetURI 가져오기
        String targetURI = (String)session.getAttribute("targetURI");
        System.out.println(targetURI);
        if(targetURI != null && !targetURI.equals("")) {
            session.removeAttribute("targetURI"); // targetURI는 한 번 사용하면 지워준다
            return "redirect:" + targetURI;
        }

		if (vo != null) {
			session.setAttribute("memberId", vo.getMemberId());
			reAttr.addFlashAttribute("result", "loginSuccess");
			return "redirect:/main/main";
		} else {
			return "redirect:/main/member/login";
		}
	} // end loginPOST()
	
	// 로그아웃 메소드
	@GetMapping("/logout")
	public String logoutGET(HttpSession session, RedirectAttributes reAttr) {
		logger.info("logoutGET() 호출");
		session.removeAttribute("memberId");
		reAttr.addFlashAttribute("result", "logoutSuccess");
		return "redirect:/main/main";
	} // end logoutGET()
	
	// 마이페이지 메소드
	@GetMapping("/mypage")
	public void myPage() {
		logger.info("mypPage() 호출");
	} // end myPage()
	
	@GetMapping("/update")
	public void updateGET() {
		logger.info("updateGET() 호출");
		
	} // end updateGET()
	
	@PostMapping("/update")
	public String updatePOST(MemberVO vo, RedirectAttributes reAttr) {
		logger.info("updatePOST() 호출");
		int result = memberService.update(vo);
		if (result == 1) {
			logger.info(result + "행 수정");
			reAttr.addFlashAttribute("result", "updateSuccess");
			return "redirect:/main/member/mypage";
		} else {
			return "redirect:/main/member/update";
		}
	} // end updatePOST()
	
	@GetMapping("/delete")
	public void deleteGET() {
		logger.info("deleteGET() 호출");
	} // end deleteGET()
	
	@PostMapping("/delete")
	public String deletePOST(MemberVO vo, RedirectAttributes reAttr, HttpSession session) {
		logger.info("deletePOST() 호출");
		int result = memberService.delete(vo);
		if (result == 1) {
			logger.info(result + "행 삭제");
			reAttr.addFlashAttribute("result", "deleteSuccess");
			session.removeAttribute("memberId");
			return "redirect:/main/main";
		} else {
			return "redirect:/main/member/delete";
		}
	} // end deletePOST()
	
	@GetMapping("/main")
	public String main() {
		logger.info("메인으로 가기 호출");
		return "redirect:/main/main";
	} // end main()
} // end MemberController
