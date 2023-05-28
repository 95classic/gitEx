package edu.spring.hotel.domain;


public class HotelVO {
	private int hotelId;
	private String hotelName;
	private String hotelContent;
	private int hotelPrice;
	private int reviewCnt;
	private int heartNo;
	private int heartCnt;
	
	public HotelVO() {

	}

	public HotelVO(int hotelId, String hotelName, String hotelContent, int hotelPrice, int reviewCnt, int heartNo) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelContent = hotelContent;
		this.hotelPrice = hotelPrice;
		this.reviewCnt = reviewCnt;
		this.heartNo = heartNo;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelContent() {
		return hotelContent;
	}

	public void setHotelContent(String hotelContent) {
		this.hotelContent = hotelContent;
	}

	public int getHotelPrice() {
		return hotelPrice;
	}

	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public int getHeartNo() {
		return heartNo;
	}

	public void setHeartNo(int heartNo) {
		this.heartNo = heartNo;
	}

	@Override
	public String toString() {
		return "HotelVO [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelContent=" + hotelContent
				+ ", hotelPrice=" + hotelPrice + ", reviewCnt=" + reviewCnt + ", heartNo=" + heartNo + "]";
	}
	
	
	
	
}
