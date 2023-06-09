package com.ssafy.fit.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.VideoReview;

public class VideoReviewDaoImpl implements VideoReviewDao{
	
	VideoDao video=VideoDaoImpl.getInstance();
	//key: 비디오번호키
	//value: 리뷰리스트
	private static Map<Integer, List<VideoReview>> videoReviewDb=new HashMap<>();
	
	// 싱글톤패턴
	private static VideoReviewDaoImpl instance=new VideoReviewDaoImpl();
	private VideoReviewDaoImpl () {}
	public static VideoReviewDaoImpl getInstance() {return instance;}
	
	@Override
	public int insertReview(VideoReview videoReview) {
		//리뷰를 저장할 공간을 만들어야함
		for(Video v:video.selectvideo()) {
			if(v.getNo()==videoReview.getVideoNo()) {
				if(videoReviewDb.containsKey(v.getNo()))
					videoReviewDb.get(videoReview.getVideoNo()).add(videoReview);
				else {
					List<VideoReview> reviews=new ArrayList<>();
					reviews.add(videoReview);
					videoReviewDb.put(v.getNo(),reviews);
				}
				 //댓글 개수 반환
				 return videoReviewDb.get(videoReview.getVideoNo()).size();
			}
			
		 }
		 //저장하지 못했다면 -1 반환
		 return -1;
	}
	@Override
	public List<VideoReview> selectReview(int videoNo) {
		//리뷰가 존재한다면 리뷰리스트 반환
		if(videoReviewDb.containsKey(videoNo)) {
			return videoReviewDb.get(videoNo);
		}
		//리뷰가 없다면 
		return null;
	}


	@Override
	public void saveArticleData() {
		// 목적: 유저데이터 저장.
		
		// 객체를 파일로 저장
		
		// 객체를 출력 -> 파일 
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"));
			oos.writeObject(this.userList);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void loadArticleData() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"));
			try {
				userList = (ArrayList<User>) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
