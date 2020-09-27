package com.example.eshopping.service;

import java.util.List;

import com.example.eshopping.entity.OrderDetails;
import com.example.eshopping.entity.OrderMaster;

public interface OrderDetailService {

	public OrderDetails saveOrder(OrderDetails order);
	
	public OrderMaster getOrderById(int id);
	
	public List<OrderDetails> getOrderByUserId(int userId);
	
	public List<OrderDetails> getOrders();
	
	public OrderMaster saveOrderMaster(OrderMaster order);
	
	public List<OrderMaster> getOrderMasterByUserId(int userId);
	
	public List<OrderDetails> getOrderDetailsByOrderId(int orderId);
}
