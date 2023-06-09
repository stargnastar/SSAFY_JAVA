package com.ssafy.fit.ui;

import java.util.Scanner;

import com.ssafy.fit.model.Video;
import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;

import java.util.Scanner;

public class VideoUi {


// 변수선언
VideoDao videoDao = VideoDaoImpl.getInstance();
VideoReviewDao reviewManager = VideoReviewDaoImpl.getInstance();
static Scanner sc = new Scanner(System.in);
static MainUi mainUi=new MainUi();
static VideoDaoImpl videoManager=VideoDaoImpl.getInstance();



// 싱글톤
private static VideoUi instance = new VideoUi();
private VideoUi() {
}
public static VideoUi getInstance() {
    return instance;
}

// 영상정보 메인화면
static void service() {
	boolean a = true;
    // 올바르게 입력할 때까지 반복
    while (a) {
        // 메뉴 안내
        System.out.println("---------------------------------------");
        System.out.println("1. 영상목록");
        System.out.println("0. 이전으로");
        System.out.println("---------------------------------------");

        // 메뉴 선택
        System.out.print("메뉴를 선택하세요 : ");
        int menuNum = sc.nextInt();

        // 메뉴 별 실행 내용
        if (menuNum == 1) {
            // 영상 목록 UI화면 띄움
            listVideo();
            // 올바르게 입력 했으므로 반복문 탈출
            a = false;
            break;
        } else if (menuNum == 0) {
            // 이전화면인 최초 메인화면으로 이동    
            mainUi.service();                
            // 올바르게 입력 했으므로 반복문 탈출
            a = false;
            break;
        }
        System.out.println("1또는 0을 입력해주세요.");
    }

}

static void listVideo() {

    // 기본 UI출력
    System.out.println("---------------------------------------");
    System.out.println("전체 " + videoManager.selectvideo().size() + "개");
    System.out.println("---------------------------------------");

    // 영상 목록 출력

    for (Video v : videoManager.selectvideo()) {
        System.out.println(v.getNo() + "    " + v.getTitle());
    }

    while (true) { // 올바르게 입력할 때까지 반복
        // 영상상세 선택화면
        System.out.println("---------------------------------------");
        System.out.println("1. 영상상세");
        System.out.println("0. 이전으로");
        System.out.println("---------------------------------------");

        // 메뉴 선택
        System.out.print("메뉴를 선택하세요 : ");
        int menuNum = sc.nextInt();
        if (menuNum == 1) {
            // 영상번호 선택
            System.out.print("영상번호를 입력하세요 : ");
            int videoNum = sc.nextInt();
            detailVideo(videoNum);
            break;
        } else if (menuNum == 0) {
            // 영상정보 메인화면
            service();
            break;
        } else {
            System.out.println("1또는 0을 입력하세요.");
        }
    }

}

static void detailVideo(int videoNo) {
    //영상 정보 출력
    System.out.println("---------------------------------------");
    System.out.println("번호 : "+videoNo);
    System.out.println("제목 : "+videoManager.selectvideobyNo(videoNo).getTitle());
    System.out.println("운동 : "+videoManager.selectvideobyNo(videoNo).getPart());
    System.out.println("영상URL : "+videoManager.selectvideobyNo(videoNo).getUrl());

    System.out.println("---------------------------------------");
    VideoReviewUi reviewUi=VideoReviewUi.getInstance(videoNo);
    reviewUi.listreview();

    }
}