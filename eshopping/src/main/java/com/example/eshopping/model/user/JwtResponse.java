package com.example.eshopping.model.user;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private int userId;
	private String userName;
	private String location;

	public JwtResponse(String jwttoken, int userId, String userName, String location) {
		this.jwttoken = jwttoken;
		this.userId = userId;
		this.userName = userName;
		this.location = location;
	}

	public String getToken() {
		return this.jwttoken;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public String getUserName() {
		return this.userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLocation() {
		return this.location;
	}
	
	
}