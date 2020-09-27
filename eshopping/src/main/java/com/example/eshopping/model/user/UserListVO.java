package com.example.eshopping.model.user;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.User;

public class UserListVO extends BaseResponse{

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
