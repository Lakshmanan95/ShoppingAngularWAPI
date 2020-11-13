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
import com.example.eshopping.entity.Product;
import com.example.eshopping.model.cart.CartRequest;
import com.example.eshopping.model.cart.CartResponse;
import com.example.eshopping.model.cart.UpdateCartRequest;
import com.example.eshopping.service.CartService;
import com.example.eshopping.service.ProductService;
import com.example.eshopping.util.DateTimeUtil;
import com.example.eshopping.util.JSONUtil;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addToCart")
	public CartResponse addToCart(@RequestBody CartRequest request) {
		CartResponse response = new CartResponse();
		try {
			System.out.println(JSONUtil.toJson(request));
			Product product = productService.getProductById(request.getProductId());
			System.out.println(JSONUtil.toJson(product));
			List<Cart> cartListValue = cartService.getCartByUserId(request.getUserId());
//			Cart cart = cartService.findByUserIdAndProductId(request.getProductId(),request.getUserId());
			Cart cart = new Cart();
			for(Cart cartDetails : cartListValue) {
				if(cartDetails.getProductId() == request.getProductId()) {
					cart.setId(cartDetails.getId());
				}else {
					cart = null;
				}
			}
//			Cart cart = cartService.findByUserIdAndProductId(request.getProductId(), request.getUserId());
			System.out.println(JSONUtil.toJson(cart));
			if(cart == null) {
				cart = new Cart();
				cart.setQuantity(request.getQuantity());
			}			
			System.out.println(" "+request.getQuantity()+" quantity "+ product.getQuantity());
			cart.setPrice(request.getPrice());
			cart.setProductId(request.getProductId());
			cart.setProductName(request.getProductName());
			cart.setQuantity(cart.getQuantity() + request.getQuantity());
			cart.setUserId(request.getUserId());
			cart.setDescription(product.getDescription());
			cart.setCreatedDate(DateTimeUtil.getDateAndTime());
			cart.setExternalShop(product.isExternalShop());
			cart.setLocation(request.getLocation());
			System.out.println(" "+request.getQuantity()+" quantity "+ product.getQuantity());
			if(request.getQuantity() > product.getQuantity()) {
				response.setStatus(CommonConstant.ERROR);
				response.setMessage("Limit exceed for this product");
				return response;
			}
			cartService.saveToCart(cart);
			int updateQuantity = product.getQuantity() - request.getQuantity();
			product.setQuantity(updateQuantity);
			productService.saveProduct(product);
			List<Cart> cartList = cartService.getCartByUserId(request.getUserId());
			
			response.setCartList(cartList);			
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
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
			Cart cartValue = cartService.getCartById(id);
			Product product = productService.getProductById(cartValue.getProductId());
			product.setQuantity(product.getQuantity() + cartValue.getQuantity());
			productService.saveProduct(product);
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
				Product product = productService.getProductById(cartValue.getId());				
				if(cartValue.getQuantity() > cart.getQuantity()) {
					product.setQuantity(product.getQuantity() - cart.getQuantity());
				}
				else if(cartValue.getQuantity() < cart.getQuantity()) {
					product.setQuantity(product.getQuantity() + cart.getQuantity());
				}
				productService.saveProduct(product);
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
