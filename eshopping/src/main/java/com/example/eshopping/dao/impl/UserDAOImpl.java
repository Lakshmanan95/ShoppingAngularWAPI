package com.example.eshopping.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.eshopping.entity.User;

@Service
@Transactional
public class UserDAOImpl {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public User getUserById(int id) {
		String query = "select id, first_name, last_name, email, phone_number, location, zip_code, role_id from user where id="+id;
		User user = (User) jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper(User.class));
		return user;
	}
}
