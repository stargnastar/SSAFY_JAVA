package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.VideoReview;

public interface VideoReviewDao {
	int insertReview(VideoReview videoReview);
	List<VideoReview> selectReview(int videoNo);
	void saveUserData(); // 사용자 데이터를 저장.
	void loadUserData();
}
