package com.example.eshopping.serviceImpl;

import com.example.eshopping.dao.impl.UserDAOImpl;
import com.example.eshopping.entity.Roles;
import com.example.eshopping.entity.User;
import com.example.eshopping.repo.RoleRepository;
import com.example.eshopping.repo.UserRepository;
import com.example.eshopping.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDAOImpl userDAO;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	@Override
	public User findByUsername(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public User findUserById(int id) {
		return userDAO.getUserById(id);
	}
	
	@Override
	public List<Roles> getRoles(){
		return roleRepository.findAll();
		
	}
	
	
	
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
}
