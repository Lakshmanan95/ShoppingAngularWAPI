package com.example.eshopping.service;



import java.util.List;

import com.example.eshopping.entity.Roles;
import com.example.eshopping.entity.User;


public interface UserService {

	public User saveUser(User user);
	
	public User findByEmailAndPassword(String email, String Password);
	
	public User findByUsername(String userName);
	
	public User findByEmail(String email);
	
	public List<User> findAllUsers();
	
	public User findUserById(String id);
	
	public List<Roles> getRoles();
	
}
