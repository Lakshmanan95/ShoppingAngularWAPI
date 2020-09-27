package com.example.eshopping.controller;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.common.CommonConstant;
import com.example.eshopping.config.JwtTokenUtil;
import com.example.eshopping.entity.Roles;
import com.example.eshopping.entity.User;
import com.example.eshopping.model.user.EmailExistResponse;
import com.example.eshopping.model.user.FogerCredentialsResponse;
import com.example.eshopping.model.user.JwtRequest;
import com.example.eshopping.model.user.JwtResponse;
import com.example.eshopping.model.user.RoleResponse;
import com.example.eshopping.model.user.UserRequest;
import com.example.eshopping.model.user.UserResponse;
import com.example.eshopping.model.user.UserUpdateRequest;
import com.example.eshopping.service.UserService;
import com.example.eshopping.util.EncryptDecrypt;
import com.example.eshopping.util.JSONUtil;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	UserService userService;
	

		
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
	
	@RequestMapping(method = RequestMethod.POST, value ="/registerUser")
	public UserResponse registerUser(@RequestBody UserRequest request) {
		UserResponse response = new UserResponse();
		try {
			System.out.println("user "+JSONUtil.toJson(request.getUser()));
			User registerUser = new User();
				if(request.getUser().getId() != 0) {
					request.getUser().setCreatedDate(new Date());
					registerUser = userService.saveUser(request.getUser());
				}else {
					User checkUserExists = userService.findByUsername(request.getUser().getUserName());
					User emailExists = userService.findByEmail(request.getUser().getEmail());
					if(checkUserExists != null) {
						response.setMessage("User Already Exists");
						response.setStatus(CommonConstant.ERROR);
						response.setStatusCode(01);
						return response;
					}
					if(emailExists != null) {
						response.setMessage("Email Already taken");
						response.setStatus(CommonConstant.ERROR);
						response.setStatusCode(01);
						return response;
					}
					String encodedPassword = EncryptDecrypt.encrypt(request.getUser().getPassword());
					request.getUser().setPassword(encodedPassword);
					registerUser = userService.saveUser(request.getUser());
					System.out.println(JSONUtil.toJson(registerUser));
					if(registerUser == null) {
						response.setStatus("Error");
						response.setMessage("Register Failed");
						response.setStatusCode(01);
					}else {
						final String token = jwtTokenUtil.generateToken(registerUser);
						response.setJwt(token);
						response.setUserId(registerUser.getId());
						response.setUserName(registerUser.getUserName());
						response.setStatus("Success");
					}
				}		
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus("Error");
			response.setStatusCode(01);
			response.setMessage("Registration Failed");
		}
		return response;
	}

	
	@RequestMapping(method = RequestMethod.POST, value ="/forgetPassword")
	public FogerCredentialsResponse forgetPassword(@RequestBody UserUpdateRequest request) {
		FogerCredentialsResponse response = new FogerCredentialsResponse();
		try {
			User user = userService.findByUsername(request.getUsername());
			if(user == null) {
				response.setStatus(CommonConstant.ERROR);
				response.setMessage("User not Found");
				return response;
			}
			String decryptPassword = EncryptDecrypt.decrypt(user.getPassword());
			response.setPassword(decryptPassword);
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			response.setStatus(CommonConstant.ERROR);
			response.setMessage("User not Found");
			System.out.println(e);
			response.setStatusCode(01);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/forgetUsername")
	public FogerCredentialsResponse forgetUserName(@RequestBody UserUpdateRequest request) {
		FogerCredentialsResponse response = new FogerCredentialsResponse();
		try {
			User user = userService.findByEmail(request.getEmail());
			if(user == null) {
				response.setStatus(CommonConstant.ERROR);
				response.setMessage("Email Id not Found");
				return response;
			}
			response.setUsername(user.getUserName());
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			response.setStatus(CommonConstant.ERROR);
			response.setMessage("Email Id not Found");
			response.setStatusCode(01);
			System.out.println(e);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/emailExists")
	public EmailExistResponse emailExists(@RequestBody UserUpdateRequest request) {
		EmailExistResponse response = new EmailExistResponse();
		try {
			User user = userService.findByEmail(request.getEmail());
			if(user != null) {
				response.setEmailExists(true);
				response.setMessage("Email Already Exists");
			}
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			response.setMessage("Email Exists Failed");
			response.setStatus(CommonConstant.ERROR);
			response.setStatusCode(01);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getRoles")
	public RoleResponse getRoles() {
		RoleResponse response = new RoleResponse();
		try {
			List<Roles> roles = userService.getRoles();
			response.setRoles(roles);
			response.setStatus(CommonConstant.SUCCESS);
		}catch(Exception e) {
			response.setStatus(CommonConstant.ERROR);
			response.setStatusCode(01);
			System.out.println(e);
		}
		return response;
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}