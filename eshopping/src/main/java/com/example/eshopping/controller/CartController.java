package com.example.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.common.CommonConstant;
import com.example.eshopping.entity.Cart;
import com.example.eshopping.model.cart.CartRequest;
import com.example.eshopping.model.cart.CartResponse;
import com.example.eshopping.model.cart.UpdateCartRequest;
import com.example.eshopping.service.CartService;
import com.example.eshopping.util.JSONUtil;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("/addToCart")
	public CartResponse addToCart(@RequestBody CartRequest request) {
		CartResponse response = new CartResponse();
		try {
			Cart cart = cartService.findByUserIdAndProductId(request.getUserId(), request.getProductId());
			if(cart == null) {
				cart = new Cart();
			}
			cart.setPrice(request.getPrice());
			cart.setProductId(request.getProductId());
			cart.setProductName(request.getProductName());
			cart.setQuantity(request.getQuantity());
			cart.setUserId(request.getUserId());
			cartService.saveToCart(cart);
			List<Cart> cartList = cartService.getCartByUserId(request.getUserId());
			response.setCartList(cartList);
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			 
		}
		return response;
	}
	
	@GetMapping("/getCart/{id}")
	public CartResponse getCartByUserId(@PathVariable int id) {
		CartResponse response = new CartResponse();
		try {
			List<Cart> cartList = cartService.getCartByUserId(id);
			response.setCartList(cartList);
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	@GetMapping("/removeFromCart/{id}")
	public BaseResponse removeFromCart(@PathVariable int id) {
		BaseResponse response = new BaseResponse();
		try {
			int delete = cartService.deleteById(id);
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	@PostMapping("/updateCart")
	public CartResponse updateCart(@RequestBody UpdateCartRequest request) {
		CartResponse response = new CartResponse();
		try {
			System.out.println(JSONUtil.toJson(request.getCart()));
			for(CartRequest cart : request.getCart()) {
				Cart cartValue = cartService.getCartById(cart.getId());
				cartValue.setQuantity(cart.getQuantity());
//				cartValue.setPrice(cart.getPrice() * cart.getQuantity());
				cartService.saveToCart(cartValue);
			}
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
}
