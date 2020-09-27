package com.example.eshopping.model.user;

import com.example.eshopping.common.BaseResponse;

public class EmailExistResponse extends BaseResponse{

	boolean emailExists = false;

	public boolean isEmailExists() {
		return emailExists;
	}

	public void setEmailExists(boolean emailExists) {
		this.emailExists = emailExists;
	}
	
	
}
