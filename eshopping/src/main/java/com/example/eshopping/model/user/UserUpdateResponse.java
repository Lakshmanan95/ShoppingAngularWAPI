package com.example.eshopping.model.user;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.User;

public class UserUpdateResponse extends BaseResponse{

	User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
