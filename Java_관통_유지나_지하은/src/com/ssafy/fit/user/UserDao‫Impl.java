package com.ssafy.fit.user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserDao‫Impl implements UserDao{
	//싱글톤
	private static UserDao‫Impl instance=new UserDao‫Impl();
	private UserDao‫Impl() {}
	public static UserDao‫Impl getInstance() {return instance;}
	
	//등록된 사용자 리스트
	private ArrayList<User> userList=new ArrayList<>();
	//현재 로그인 한 사용자
	User loginUser=null;
	
	
	//현재 로그인 한 유저 반환
	@Override
	public User getLoginUser() {
		return loginUser;
	}
	
	//로그인
	@Override
	public User login(String id, String password) {
//	    id가 존재여부 확인
			for(User user : this.userList) {
				//패스워드 확인
				if(user.getUserId().equals(id) && user.getPassword().equals(password)) {
					this.loginUser = user;
					return user;
				}
			}
			
			return null;
	}
	@Override
	public void logout() {
		//현재 로그인한 유저 null로 설정
		this.loginUser=null;
		
	}
	@Override
	public void saveUserData() {
		// 목적:  등록한 유저 데이터을 저장.
		
		// 객체를 파일로 저장을 하려고 합니다.
		
		// 객체를 출력 -> 파일 생성
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
	public void loadUserData() {
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
	@Override
	public ArrayList<User> getUserList() {
		//사용자 목록 반환
		return this.userList;
	}
	@Override
	public boolean signUp(User user) {
		//중복되는 id가 있는지 확인.
				for(User u : this.userList) {
					if(u.getUserId().equals(user.getUserId()) ) {
						System.out.println("아이디가 중복되었습니다.");
						return false;
					}
					
					else if(u.getNickName().equals(user.getNickName())) {
						System.out.println("닉네임이 중복되었습니다.");
						return false;

					}
					else if(u.getEmail().equals(user.getEmail())) {
						System.out.println("이메일이 중복되었습니다.");
						return false;
					}
				}
				//중복 상황이 없다면 사용자 등록
				this.userList.add(user);
				return true;
		
	}
	
	
}
