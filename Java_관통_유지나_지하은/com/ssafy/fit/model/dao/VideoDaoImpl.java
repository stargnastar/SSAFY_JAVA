package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.ssafy.fit.model.Video;

public class VideoDaoImpl implements VideoDao {
	private List<Video> list = new ArrayList<>(); // 비디오 리스트
	

	// 싱글톤 패턴 생성
	private static VideoDaoImpl instance = new VideoDaoImpl();

	private VideoDaoImpl() {
	}

	public static VideoDaoImpl getInstance() {
		return instance;
	}
	
	

	//비디오리스트 전체 반환
	@Override
	public List<Video> selectvideo() throws IOException{
		return list;
	
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")));
		String str = null; 
		StringBuilder sb = new StringBuilder();

		//Json파일->문자열
		while((str = br.readLine())!= null) {
			sb.append(str).append("\n");
		}
		
		Gson gson = new Gson();
		
		Video[] arr = gson.fromJson(sb.toString(), Video[].class);
		
		for (int i = 0; i <8; i++) {
			videoList.add(arr[i]);
		
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("전체 8개");
		System.out.println("--------------------------------------------------------");
		for(int i = 0; i<8;i++) {
			int num = i+1;
			System.out.println(num +"  "+videoList.get(i).getTitle());
			
		}
		System.out.println("--------------------------------------------------------");
		
		
		return videoList;
	}

	@Override
	public Video selectvideobyNo(int no) {
		for(Video v:list) {
			//비디오 번호가 같으면 비디오 검색결과 리턴
			if(v.getNo()==no)
				return v;
		}
		//없다면 null리턴.
		return null;
	}
	
	@Override
	public void addVideo(Video v) {
		list.add(v);
	}



}
