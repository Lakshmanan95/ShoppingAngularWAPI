package com.example.eshopping.model.order;

import java.util.List;

import com.example.eshopping.entity.OrderDetails;
import com.example.eshopping.entity.OrderMaster;

public class OrderFinal {

	OrderMaster orderMaster;
	List<OrderDetails> orderDetails;
	
	public OrderMaster getOrderMaster() {
		return orderMaster;
	}
	public void setOrderMaster(OrderMaster orderMaster) {
		this.orderMaster = orderMaster;
	}
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
}
