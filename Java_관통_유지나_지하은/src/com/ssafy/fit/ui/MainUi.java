package com.ssafy.fit.ui;

import java.util.List;
import java.util.Scanner;

import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;
import com.ssafy.fit.user.User;
import com.ssafy.fit.user.UserDao;
import com.ssafy.fit.user.UserDao‫Impl;

public class MainUi {

	// 객체 생성
	static VideoDao videoDao = VideoDaoImpl.getInstance();
	static VideoReviewDao reviewManager = VideoReviewDaoImpl.getInstance();
	static Scanner sc = new Scanner(System.in);
	static VideoDaoImpl videoManager = VideoDaoImpl.getInstance();

	static VideoUi videoUi = VideoUi.getInstance();
	static UserDao userManager = UserDao‫Impl.getInstance();

	void login() {
		while (true) {
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그아웃");
			System.out.println("0. 종료");
			System.out.println("---------------------------------------");
			System.out.print("메뉴를 선택하세요 : ");
			int menuNum = sc.nextInt();
			System.out.println("---------------------------------------");

			if (menuNum == 1) {
				System.out.print("아이디를 입력하세요 : ");
				String userId = sc.next();
				System.out.print("비밀번호를 입력하세요 : ");
				String password = sc.next();
				userManager.login(userId, password);
				if (userManager.getLoginUser() != null) {
					System.out.println("로그인이 완료되었습니다.\n" + userManager.getLoginUser().getNickName() + "님 환영합니다.");
				} else {
					System.out.println("로그인 실패!");
				}
				break;
			} else if (menuNum == 2) {
				System.out.print("아이디를 입력하세요 : ");
				String userId = sc.next();
				System.out.print("비밀번호를 입력하세요 : ");
				String password = sc.next();
				System.out.print("이름을 입력하세요 : ");
				String userName = sc.next();
				System.out.print("닉네임을 입력하세요 : ");
				String nickName = sc.next();
				System.out.print("나이를 입력하세요 : ");
				int age = sc.nextInt();
				System.out.print("이메일을 입력하세요 : ");
				String email = sc.next();
				
				User user = new User(userId, password, userName, nickName, age, email);
				userManager.signUp(user);
				System.out.println("---------------------------------------");
				System.out.println("회원가입이 완료되었습니다.");
				break;
			} else if (menuNum == 3) {
				userManager.logout();
				System.out.println("로그아웃 되었습니다.");
				break;
			} else if (menuNum == 0) {
				exit();
				break;
			}
			System.out.println("0,1,2중에서 입력해주세요.");
		}

	}

	public void service() {

		// 기본 화면 UI
		System.out.println("---------------------------------------");
		System.out.println("자바로 구현하는 SSAFIT");
		System.out.println("---------------------------------------");
		login();
		System.out.println("---------------------------------------");

		System.out.println("1. 영상정보");
		System.out.println("0. 종료");
		System.out.println("---------------------------------------");
		while (true) {
			// 메뉴 선택
			System.out.print("메뉴를 선택하세요 : ");
			int menuNum = sc.nextInt();
			// 영상 목록으로 넘어감
			if (menuNum == 1) {
				VideoUi.service();
				break;

			}
			// 종료
			else if (menuNum == 0) {
				exit();
				break;
			}
			// 입력 오류
			else {
				System.out.println("1또는 0을 입력하세요.");
				System.out.println("---------------------------------------");
			}
		}
	}

	void exit() {
		System.out.println("---------------------------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("---------------------------------------");
		return;
	}

}
