package com.example.eshopping.model.order;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.OrderDetails;

public class OrderResponse extends BaseResponse{

	OrderDetails orderDeatils;
	List<OrderDetails> ordersList;
	List<OrderFinal> orderFinal;

	public OrderDetails getOrderDeatils() {
		return orderDeatils;
	}

	public void setOrderDeatils(OrderDetails orderDeatils) {
		this.orderDeatils = orderDeatils;
	}

	public List<OrderDetails> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<OrderDetails> ordersList) {
		this.ordersList = ordersList;
	}

	public List<OrderFinal> getOrderFinal() {
		return orderFinal;
	}

	public void setOrderFinal(List<OrderFinal> orderFinal) {
		this.orderFinal = orderFinal;
	}
	
	
	
}
