package com.ssafy.fit.model;

public class VideoReview {
	private int videoNo; //영상 번호
	private int reviewNo; //리뷰 번호
	private String nickName; // 닉네임
	private String content; //댓글 내용
	
	
	//constructor
	public VideoReview(int videoNo, int reviewNo, String nickName, String content) {
		this.videoNo = videoNo;
		this.reviewNo = reviewNo;
		this.nickName = nickName;
		this.content = content;
	}
	//getter setter
	public int getVideoNo() {
		return videoNo;
	}
	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "VideoReview [videoNo=" + videoNo + ", reviewNo=" + reviewNo + ", nickName=" + nickName + ", content="
				+ content + "]";
	}
	
	
	
	
	
	
}
