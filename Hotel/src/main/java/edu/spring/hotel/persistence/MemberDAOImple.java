package edu.spring.hotel.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.MemberVO;

@Repository
public class MemberDAOImple implements MemberDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(MemberDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.MemberMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert 등록

	@Override
	public MemberVO select(String memberId) {
		logger.info("select()호출 : memberId = " + memberId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_member_id", memberId);
	} // end select 상세검색

	@Override
	public int update(MemberVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update 수정

	@Override
	public int delete(MemberVO memberId) {
		logger.info("delete() 호출 : memberId = " + memberId);
		return sqlSession.delete(NAMESPACE + ".delete", memberId);
	} // end delete 삭제

	@Override
	public int idcheck(MemberVO vo) {
		logger.info("idcheck()호출 : vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".idcheck", vo);
	} // end idcheck 아이디 중복체크

	@Override
	public MemberVO login(MemberVO vo) {
		logger.info("login() 호출");
		logger.info("vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".login", vo);
	} // end login 로그인
	
} // end MemberDAOImple
