package com.example.eshopping.dao;

import java.util.List;

import com.example.eshopping.entity.OrderDetails;

public interface OrderDetailDAO {

	public List<OrderDetails> getOrderByUserId(int userId);
	
	public List<OrderDetails> getOrders();
}
