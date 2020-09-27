package com.example.eshopping.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eshopping.dao.OrderDetailDAO;
import com.example.eshopping.entity.OrderDetails;
import com.example.eshopping.entity.OrderMaster;
import com.example.eshopping.repo.OrderDetailRepository;
import com.example.eshopping.repo.OrderMasterRepository;
import com.example.eshopping.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	OrderDetailDAO orderDetailDAO;
	
	@Autowired
	OrderDetailRepository orderRepository;
	
	@Autowired
	OrderMasterRepository orderMasterRepository;
	
	public OrderDetails saveOrder(OrderDetails order) {
		return this.orderRepository.save(order);
	}
	
	public OrderMaster getOrderById(int id) {
		return this.orderMasterRepository.findById(id);
	}
	
	public List<OrderDetails> getOrderByUserId(int userId) {
		return this.orderDetailDAO.getOrderByUserId(userId);
	}
	
	public List<OrderDetails> getOrders(){
		return this.orderDetailDAO.getOrders();
	}
	
	@Override
	public OrderMaster saveOrderMaster(OrderMaster order) {
		return this.orderMasterRepository.save(order);
	}
	
	@Override
	public List<OrderMaster> getOrderMasterByUserId(int userId) {
		return this.orderMasterRepository.findByUserId(userId);
	}
	
	@Override
	public List<OrderDetails> getOrderDetailsByOrderId(int orderId){
		return this.orderRepository.findByOrderId(orderId);
	}
}

