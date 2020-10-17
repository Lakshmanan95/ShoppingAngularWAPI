package com.example.eshopping.model.order;

import java.util.List;

import com.example.eshopping.entity.Cart;
import com.example.eshopping.entity.OrderDetails;
import com.example.eshopping.entity.OrderMaster;

public class OrderRequest {

	OrderMaster order;
	List<Cart> cart;
	private int userId;
	List<UpdateOrder> updateOrder;

	public OrderMaster getOrder() {
		return order;
	}

	public void setOrder(OrderMaster order) {
		this.order = order;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<UpdateOrder> getUpdateOrder() {
		return updateOrder;
	}

	public void setUpdateOrder(List<UpdateOrder> updateOrder) {
		this.updateOrder = updateOrder;
	}
	
	
}
