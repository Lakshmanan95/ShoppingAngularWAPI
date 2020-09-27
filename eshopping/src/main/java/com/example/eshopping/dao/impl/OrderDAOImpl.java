package com.example.eshopping.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.eshopping.dao.OrderDetailDAO;
import com.example.eshopping.entity.OrderDetails;

@Service
@Transactional
public class OrderDAOImpl implements OrderDetailDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<OrderDetails> getOrderByUserId(int userId){
		List<OrderDetails> orders = new ArrayList<>();
		String query = "Select * from order_details where userId ="+userId+" order by Id Desc";
		orders = jdbcTemplate.query(query, new BeanPropertyRowMapper(OrderDetails.class));	
		return orders;
	}
	
	@Override
	public List<OrderDetails> getOrders(){
		List<OrderDetails> orders = new ArrayList<>();
		String query = "Select * from order_details where order_status != 'Delivered' order by Id Desc limit 0, 10";
		orders = jdbcTemplate.query(query, new BeanPropertyRowMapper(OrderDetails.class));	
		return orders;
	}
}

