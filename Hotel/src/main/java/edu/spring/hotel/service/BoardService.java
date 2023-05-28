package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.BoardVO;
import edu.spring.hotel.pageutil.PageCriteria;

//CRUD(Create, Read, Update, Delete)

public interface BoardService {
	// 게시글 작성
	int create(BoardVO vo);
	// 게시글 전체 읽기
	List<BoardVO> read(PageCriteria criteria);
	// 게시글 하나 읽기
	BoardVO read(int boardId);
	// 게시글 수정
	int update(BoardVO vo);
	// 게시글 삭제
	int delete(int boardId);
	// 전체 게시글 수 받아오기
	int getTotalCounts();
} // end BoardService
