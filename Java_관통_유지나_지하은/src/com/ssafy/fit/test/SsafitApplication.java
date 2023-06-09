package com.ssafy.fit.test;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;
import com.ssafy.fit.ui.MainUi;
import com.ssafy.fit.ui.VideoUi;

public class SsafitApplication {
	public static void main(String[] args) {
		//비디오와 리뷰리스트 추가
		VideoDao video=VideoDaoImpl.getInstance();
		VideoReviewDao review=VideoReviewDaoImpl.getInstance();
		
		Video v1=new Video(1,"상체운동 쉬워요","상체","네이버ㅓㅓㅓ");
		Video v2=new Video(2,"하체운동 쉬워요","하체","다음ㅁㅁㅁ");

		video.addVideo(v1);
		video.addVideo(v2);
	
		
		VideoReview r1=new VideoReview(1, 1, "누구쓰", "아 정말 재미있다.");
		VideoReview r2=new VideoReview(1, 2, "누구쓰dm", "아 정말 재미있다dm.");
		review.insertReview(r1);
		review.insertReview(r2);
		System.out.println(review.selectReview(1).size()); 
		
		//Ui 구현
		MainUi mainUi=new MainUi();
		VideoUi videoUi=VideoUi.getInstance();
	
//		reviewUi.listreview(1);;
		mainUi.service();
	}
}
