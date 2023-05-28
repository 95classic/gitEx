package edu.spring.hotel.domain;

import java.util.Date;

public class BoardVO {
	private int boardId;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private Date boardDateCreated;
	private int replyCnt;
	
	public BoardVO() {

	}

	public BoardVO(int boardId, String memberId, String boardTitle, String boardContent, Date boardDateCreated,
			int replyCnt) {
		this.boardId = boardId;
		this.memberId = memberId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDateCreated = boardDateCreated;
		this.replyCnt = replyCnt;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDateCreated() {
		return boardDateCreated;
	}

	public void setBoardDateCreated(Date boardDateCreated) {
		this.boardDateCreated = boardDateCreated;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", memberId=" + memberId + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardDateCreated=" + boardDateCreated + ", replyCnt=" + replyCnt
				+ "]";
	}
	
} // end BoardVO
