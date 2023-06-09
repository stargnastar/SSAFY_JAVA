package com.ssafy.fit.model;


public class Video {
	private int no; //비디오 번호
	private String title; //비디오 제목
	private String part; // 운동 부위
	private String url; //주소
	
	
	//constructor
	public Video(int no, String title, String part, String url) {
		super();
		this.no = no;
		this.title = title;
		this.part = part;
		this.url = url;
	}

	public int getNo() {
		return no;
	}
	
	//getter setter
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	//toString 메소드 오버라이드
	@Override
	public String toString() {
		return "Video [no=" + no + ", title=" + title + ", part=" + part + ", url=" + url + "]";
	}
	
	
	
	
	
	
}
