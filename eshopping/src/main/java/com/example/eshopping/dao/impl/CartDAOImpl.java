package com.example.eshopping.dao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.eshopping.entity.Cart;

@Service
@Transactional
public class CartDAOImpl {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Cart findByProductandUserId(int productId, int userId) {
		String query = "select * from cart where product_id="+productId+" and user_id="+userId;
		Cart cart = (Cart) jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper(Cart.class));
		System.out.println("dao cart "+cart);
		return cart;
	}
	
}
