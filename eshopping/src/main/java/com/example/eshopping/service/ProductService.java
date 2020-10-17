package com.example.eshopping.service;

import java.util.List;

import com.example.eshopping.entity.Product;
import com.example.eshopping.model.product.ProductDetailsRequest;
import com.example.eshopping.model.product.ProductResponse;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public Product getProductById(int id);
	
	public Product getProductByNameAndProductLocation(String name,String location);
	
	public ProductResponse getProductByLocation(String location, int sort);
	
	public List<Product> getProduct();
	
	public ProductResponse getProductBasedOnCategory(ProductDetailsRequest request);
}
