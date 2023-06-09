package com.ssafy.fit.user;

import java.util.ArrayList;

public interface UserDao {
	User getLoginUser(); // 로그인한 사용자.
	User login(String id, String password); // 로그인 하기.
	void logout(); // 로그아웃 하기.
	void saveUserData(); // 사용자 데이터를 저장.
	ArrayList<User> getUserList(); //사용자 리스트 반환
	boolean signUp(User user);//회원가입
	void loadUserData();
}
