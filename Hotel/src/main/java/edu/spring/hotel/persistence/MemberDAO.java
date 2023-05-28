package edu.spring.hotel.persistence;

import edu.spring.hotel.domain.MemberVO;

public interface MemberDAO {
	
	int insert(MemberVO vo); // 회원 등록
	
	MemberVO select(String memberId); // 회원 상세검색
	
	int update(MemberVO vo); // 회원 수정
	
	int delete(MemberVO memberId); // 회원 삭제
	
	int idcheck(MemberVO vo); // 아이디 중복체크
	
	MemberVO login(MemberVO vo) throws Exception; // 로그인
}
