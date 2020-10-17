package com.example.eshopping.model.order;

import java.util.List;

import com.example.eshopping.entity.OrderDetails;
import com.example.eshopping.entity.OrderFile;
import com.example.eshopping.entity.OrderMaster;

public class OrderFinal {

	OrderMaster orderMaster;
	List<OrderDetails> orderDetails;
	List<OrderFile> orderFiles;
	
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
	public List<OrderFile> getOrderFiles() {
		return orderFiles;
	}
	public void setOrderFiles(List<OrderFile> orderFiles) {
		this.orderFiles = orderFiles;
	}
	
	
	
}
