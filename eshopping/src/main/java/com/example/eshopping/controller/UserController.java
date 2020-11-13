package com.example.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.common.CommonConstant;
import com.example.eshopping.config.JwtTokenUtil;
import com.example.eshopping.entity.User;
import com.example.eshopping.model.user.JwtRequest;
import com.example.eshopping.model.user.JwtResponse;
import com.example.eshopping.model.user.UpdateUser;
import com.example.eshopping.model.user.UserListVO;
import com.example.eshopping.model.user.UserUpdateRequest;
import com.example.eshopping.model.user.UserUpdateResponse;
import com.example.eshopping.service.UserService;
import com.example.eshopping.util.EncryptDecrypt;
import com.example.eshopping.util.JSONUtil;

@RestController
@RequestMapping("/authenticateUsers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String firstPage() {
		return "Hello";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getUsers")
	public UserListVO getUsersList() {
		UserListVO response = new UserListVO();
		try {
			List<User> users = userService.findAllUsers();
			response.setUsers(users);
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			response.setStatus(CommonConstant.ERROR);
			response.setStatusCode(01);
			System.out.println(e);
		}
		return response;
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		User userDetails = new User();
		
		try {
			String encodedPassword = EncryptDecrypt.encrypt(authenticationRequest.getPassword());
			userDetails = userService.findByEmailAndPassword(authenticationRequest.getEmail(), encodedPassword);
			System.out.println(JSONUtil.toJson(userDetails));
		}
		catch(Exception e) {
			System.out.println(e);
			BaseResponse response = new BaseResponse();
			response.setStatus(CommonConstant.ERROR);
			response.setMessage("Login Failed");
			response.setStatusCode(01);
			return ResponseEntity.ok(response);
		}
		
		if(userDetails != null) {
			final String token = jwtTokenUtil.generateToken(userDetails);
//			Long count = cartService.countCartItemsByUserId(userDetails.getId());
			long count=1;
			return ResponseEntity.ok(new JwtResponse(token, userDetails.getId(), userDetails.getUserName(), userDetails.getLocation()));
		}
		else {
			BaseResponse response = new BaseResponse();
			response.setStatus(CommonConstant.ERROR);
			response.setMessage("Login Failed");
			response.setStatusCode(01);
			return ResponseEntity.ok(response);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/roleUpdate")
	public BaseResponse updateRole(@RequestBody UserUpdateRequest userRequest) {
		BaseResponse response = new BaseResponse();
		try {
			User user = userService.findUserById(userRequest.getId());
			System.out.println(JSONUtil.toJson(user));
			if(user == null) {
				response.setStatus(CommonConstant.ERROR);
				response.setStatusCode(01);
				response.setMessage("User Not found");
				return response;
			}
			user.setRoleId(userRequest.getRole());
			userService.saveUser(user);
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			response.setStatus(CommonConstant.ERROR);
			System.out.println(e);
			response.setStatusCode(01);
		}
		return response;
	}
	
	
	@PostMapping("/profileUpdate")
	public UserUpdateResponse updateProfile(@RequestBody UpdateUser request) {
		UserUpdateResponse response = new UserUpdateResponse();
		try {
			System.out.println("request "+JSONUtil.toJson(request));
			User user = userService.findUserById(request.getUser().getId());
			System.out.println("user "+JSONUtil.toJson(user));
			user.setFirstName(request.getUser().getFirstName());
			user.setLastName(request.getUser().getLastName());
			user.setEmail(request.getUser().getEmail());
			user.setPhoneNumber(request.getUser().getPhoneNumber());
			user.setZipCode(request.getUser().getZipCode());
			userService.saveUser(user);
			response.setUser(user);
		}
		catch(Exception e) {
			response.setStatus(CommonConstant.ERROR);
			System.out.println(e);
			response.setStatusCode(01);
		}
		return response;
	}
	
	@PostMapping("getProfile")
	public UserUpdateResponse getProfile(@RequestBody UpdateUser request) {
		UserUpdateResponse response = new UserUpdateResponse();
		try {
			System.out.println("request "+JSONUtil.toJson(request));
			User user = userService.findUserById(request.getUser().getId());
			response.setUser(user);
		}
		catch(Exception e) {
			response.setStatus(CommonConstant.ERROR);
			System.out.println(e);
			response.setStatusCode(01);
		}
		return response;
	}
	
}
