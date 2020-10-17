package com.example.eshopping.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eshopping.common.CommonConstant;
import com.example.eshopping.entity.Product;
import com.example.eshopping.model.product.ProductDetailsRequest;
import com.example.eshopping.model.product.ProductRequest;
import com.example.eshopping.model.product.ProductResponse;
import com.example.eshopping.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/addAndUpdateProduct")
	public ProductResponse addAndUpdateProduct(@RequestBody ProductRequest request) {
		ProductResponse response = new ProductResponse();
		try {
			Product product = new Product();
			if(request.getProduct().getId() != 0) {
				product = productService.getProductById(request.getProduct().getId());
				
			}
			else {
				Product existingProduct = productService.getProductByNameAndProductLocation(request.getProduct().getProductName(), request.getProduct().getProductName());
				if(existingProduct != null) {
					response.setStatus(CommonConstant.ERROR);
					response.setMessage("Product Already Added");
				}
			}
			product.setProductName(request.getProduct().getProductName());
			product.setMainCategory(request.getProduct().getMainCategory());
			product.setCategory(request.getProduct().getCategory());
			product.setSubCategory(request.getProduct().getSubCategory());
			product.setDescription(request.getProduct().getDescription());
			product.setPrice(request.getProduct().getPrice());
			product.setQuantity(request.getProduct().getQuantity());
			product.setWeight(request.getProduct().getWeight());
			product.setProductAddUserId(request.getProduct().getProductAddUserId());
			product.setExternalShop(request.getProduct().isExternalShop());
			product.setActive(request.getProduct().isActive());
			product.setProductLocation(request.getProduct().getLocation());
			product.setProductImage(request.getProduct().getProductImage());
			product.setCreatedDate(new Date().toString());
			product.setMinVariant(request.getProduct().getMinVariant());
			product.setOfferPrice(request.getProduct().getOfferPrice());
			product.setBrand(request.getProduct().getBrand());
			product.setDefaultTimeSlot(request.getProduct().getDefaultTimeSlot());
			product.setOfferPrice(request.getProduct().getOfferPrice());
			product.setTitle(request.getProduct().getTitle());
			productService.saveProduct(product);
			response.setProduct(product);
			response.setStatus(CommonConstant.SUCCESS);
			
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
			response.setMessage("Product Add Failed");
		}
		return response;
	}
	
	@PostMapping("/getProduct")
	public ProductResponse getProduct(@RequestBody ProductRequest request) {
		ProductResponse response = new ProductResponse();
		try {
			response = productService.getProductByLocation(null, request.getSort());
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
			response.setMessage("Get Product Failed");
		}
		return response;
	}
	
	@GetMapping("/getProductById/{id}")
	public ProductResponse getProductById(@PathVariable int id) {
		ProductResponse response = new ProductResponse();
		try {
			Product product = productService.getProductById(id);
			response.setProduct(product);
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
			response.setMessage("Get Product Failed");
		}
		return response;
	}
	
	@PostMapping("/getProductBasedOnCategory")
	public ProductResponse getProductById(@RequestBody ProductDetailsRequest request) {
		ProductResponse response = new ProductResponse();
		try {
			response = productService.getProductBasedOnCategory(request);
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
			response.setMessage("Get Product by categroy Failed");
		}
		return response;
	}
}
