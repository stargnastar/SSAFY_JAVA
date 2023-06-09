package com.ssafy.fit.user;

public class User {
	private String userId;
	private String password;
	private String userName;
	private String nickName;
	private int age;
	private String email;
	
	
	public User(String userId, String password, String userName, String nickName, int age, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.nickName = nickName;
		this.age = age;
		this.email = email;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return userId + "  | " + password + "  | " + userName + "  | " + nickName + "  | " + age + "  | " + email;
	}

	
	
	
}