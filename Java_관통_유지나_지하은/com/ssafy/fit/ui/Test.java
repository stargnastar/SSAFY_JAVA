package com.ssafy.fit.ui;

import java.util.Scanner;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;

public class Test {
	
	public static void main(String[] args) {
		MainUi mainUi=MainUi.getInstance();
		VideoDao videoDao = VideoDaoImpl.getInstance();
	    VideoReviewDao reviewManager = VideoReviewDaoImpl.getInstance();
	    Scanner sc = new Scanner(System.in);    
	    
	    VideoDao videoManager=VideoDaoImpl.getInstance();
	    VideoReviewUi reviewUi=VideoReviewUi.getInstance();
	    VideoUi videoUi=VideoUi.getInstance();
	    videoManager.addVideo(new Video(1,"하체운동 가자","하체","dfdfdf"));
	    
	    mainUi.service();
		
	}
}
