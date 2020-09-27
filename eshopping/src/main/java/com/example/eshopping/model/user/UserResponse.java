package com.example.eshopping.model.user;

import com.example.eshopping.common.BaseResponse;

public class UserResponse extends BaseResponse{

	private String jwt;
	private int userId;
	private String userName;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
