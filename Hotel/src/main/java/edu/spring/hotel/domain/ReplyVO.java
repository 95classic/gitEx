package edu.spring.hotel.domain;

import java.util.Date;

public class ReplyVO {
	private int replyId;
	private String memberId;
	private int boardId;
	private String replyContent;
	private Date replyDateCreated;
	
	public ReplyVO() {

	}

	public ReplyVO(int replyId, String memberId, int boardId, String replyContent, Date replyDateCreated) {
		this.replyId = replyId;
		this.memberId = memberId;
		this.boardId = boardId;
		this.replyContent = replyContent;
		this.replyDateCreated = replyDateCreated;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDateCreated() {
		return replyDateCreated;
	}

	public void setReplyDateCreated(Date replyDateCreated) {
		this.replyDateCreated = replyDateCreated;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyId=" + replyId + ", memberId=" + memberId + ", boardId=" + boardId + ", replyContent="
				+ replyContent + ", replyDateCreated=" + replyDateCreated + "]";
	}
	
} // end ReplyVO
