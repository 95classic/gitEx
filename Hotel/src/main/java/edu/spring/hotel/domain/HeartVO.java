package edu.spring.hotel.domain;

public class HeartVO {
	private int heartNo;
	private int hotelId;
	private String memberId;
	
	public HeartVO() {

	}

	public HeartVO(int heartNo, int hotelId, String memberId) {
		super();
		this.heartNo = heartNo;
		this.hotelId = hotelId;
		this.memberId = memberId;
	}

	public int getHeartNo() {
		return heartNo;
	}

	public void setHeartNo(int heartNo) {
		this.heartNo = heartNo;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "HeartVO [heartNo=" + heartNo + ", hotelId=" + hotelId + ", memberId=" + memberId + "]";
	}
	
	
	
} // end HeartVO
