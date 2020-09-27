package com.example.eshopping.model.cart;

import java.util.List;

import com.example.eshopping.entity.Cart;

public class UpdateCartRequest {

	List<CartRequest> cart;

	public List<CartRequest> getCart() {
		return cart;
	}

	public void setCart(List<CartRequest> cart) {
		this.cart = cart;
	}
	
	
}
