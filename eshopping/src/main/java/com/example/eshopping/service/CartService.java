package com.example.eshopping.service;

import java.util.List;

import com.example.eshopping.entity.Cart;

public interface CartService {

	public Cart saveToCart(Cart cart);
	
	public List<Cart> getCartByUserId(int userId);
	
	public int deleteById(int id);
	
	public Cart getCartById(int id);
	
	public Cart findByUserIdAndProductId(int userId, int productId);
}
