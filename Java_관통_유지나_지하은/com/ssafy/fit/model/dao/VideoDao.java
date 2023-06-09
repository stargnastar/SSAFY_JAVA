package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.Video;

public interface VideoDao {
	List<Video> selectvideo();
	Video selectvideobyNo(int no);
}
