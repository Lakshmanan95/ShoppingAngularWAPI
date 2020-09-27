package com.example.eshopping.model.user;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.Roles;

public class RoleResponse extends BaseResponse{

	private List<Roles> roles;

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	
	
}
