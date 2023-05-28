package edu.spring.hotel.domain;

import java.util.Date;

public class MemberVO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private Date memberDateCreated;
	
	public MemberVO() {

	}

	public MemberVO(String memberId, String memberPw, String memberName, String memberPhone, String memberEmail,
			Date memberDateCreated) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberDateCreated = memberDateCreated;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Date getMemberDateCreated() {
		return memberDateCreated;
	}

	public void setMemberDateCreated(Date memberDateCreated) {
		this.memberDateCreated = memberDateCreated;
	}

	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberDateCreated="
				+ memberDateCreated + "]";
	}
	
}
