package com.ssafy.fit.model.dao;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.VideoReview;

public class modelImplTest {
	public static void main(String[] args) {
		
		VideoDao video=VideoDaoImpl.getInstance();
		VideoReviewDao review=VideoReviewDaoImpl.getInstance();
		
		Video v1=new Video(1,"상체운동 쉬워요","상체","네이버ㅓㅓㅓ");
		Video v2=new Video(2,"하체운동 쉬워요","하체","다음ㅁㅁㅁ");

		video.addVideo(v1);
		video.addVideo(v2);
		System.out.println(video.selectvideo());  
		
		VideoReview r1=new VideoReview(1, 1, "누구쓰", "아 정말 재미있다.");
		VideoReview r2=new VideoReview(1, 2, "누구쓰dm", "아 정말 재미있다dm.");
		review.insertReview(r1);
		review.insertReview(r2);
		System.out.println(review.selectReview(1)); 
		
	}

}
