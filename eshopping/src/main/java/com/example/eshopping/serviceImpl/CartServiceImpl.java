package com.example.eshopping.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eshopping.entity.Cart;
import com.example.eshopping.repo.CartRepository;
import com.example.eshopping.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	@Override
	public Cart saveToCart(Cart cart) {
		return this.cartRepository.save(cart);
	}
	
	@Override
	public List<Cart> getCartByUserId(int userId){
		return this.cartRepository.findByUserId(userId);
	}
	
	@Override
	public int deleteById(int id) {
		return this.cartRepository.deleteById(id);
	}
	
	@Override
	public Cart getCartById(int id) {
		return this.cartRepository.findById(id);
	}
	
	@Override
	public Cart findByUserIdAndProductId(int userId, int productId) {
		return this.cartRepository.findByUserIdAndProductId(userId, productId);
	}
}
