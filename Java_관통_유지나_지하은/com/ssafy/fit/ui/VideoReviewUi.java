package com.ssafy.fit.ui;

import java.util.Scanner;

import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;

public class VideoReviewUi {
	// 객체생성
	static Scanner sc = new Scanner(System.in);
	static VideoReviewDao review = VideoReviewDaoImpl.getInstance();
	static VideoUi videoUi = VideoUi.getInstance();

	// 변수 선언
	private static int videoNo;

	// 싱글톤
	private static VideoReviewUi instance = new VideoReviewUi(videoNo);

	private VideoReviewUi(int videoNo) {
		this.videoNo = videoNo;
	}

	public static VideoReviewUi getInstance(int videoNo) {
		return instance;
	}

	// 리뷰리스트 출력
	public static void listreview() {
		VideoReviewDao review = VideoReviewDaoImpl.getInstance();
		System.out.println("---------------------------------------");
		if (review.selectReview(videoNo) != null) {
			System.out.println("영상 리뷰 : " + review.selectReview(videoNo).size() + "개");
			System.out.println("---------------------------------------");

			// 리뷰리스트 출력

			for (VideoReview r : review.selectReview(videoNo)) {
				System.out.println(r.getReviewNo() + " " + r.getContent());
			}
		} else {
			System.out.println("영상 리뷰 : 0개");
			System.out.println("---------------------------------------");
		}
		service();
	}

	public static void service() {
		while (true) {
			System.out.println("---------------------------------------");
			System.out.println("1. 리뷰등록");
			System.out.println("0. 이전으로");
			System.out.println("---------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			// 메뉴 선택
			int menu = sc.nextInt();
			if (menu == 1) {
				registReview();
				break;
			} else if (menu == 0) {
				videoUi.detailVideo(videoNo);
				break;
			} else {
				System.out.println("0 또는 1을 입력하세요.");
			}
		}
	}

	public static void registReview() {
		VideoReviewDao review = VideoReviewDaoImpl.getInstance();
		// 유저 정보 입력받음 (USER구현시 수정 필요)
		System.out.println("닉네임을 입력하세요 : ");
		String nickName = sc.next();
		System.out.println("내용을 입력하세요 : ");
		String content = sc.next();
		if (review.selectReview(videoNo) != null) {
			VideoReview r = new VideoReview(videoNo, review.selectReview(videoNo).size() + 1, nickName, content);
			review.insertReview(r);
		} else {
			VideoReview r = new VideoReview(videoNo, 1, nickName, content);
			review.insertReview(r);
		}
		System.out.println(review.selectReview(1));
		System.out.println("리뷰가 정상적으로 등록되었습니다.");

		videoUi.listVideo();
	}

}
