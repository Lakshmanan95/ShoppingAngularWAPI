package com.example.eshopping.model.cart;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.Cart;

public class CartResponse extends BaseResponse{

	private List<Cart> cartList;

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}
	
	
}
