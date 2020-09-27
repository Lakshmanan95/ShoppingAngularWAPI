package com.example.eshopping.service;

import java.util.List;

import com.example.eshopping.entity.Product;
import com.example.eshopping.model.product.ProductDetailsRequest;

public interface ProductService {

	public Product saveProduct(Product product);
	
	public Product getProductById(int id);
	
	public Product getProductByNameAndProductLocation(String name,String location);
	
	public List<Product> getProductByLocation(String location);
	
	public List<Product> getProduct();
	
	public List<Product> getProductBasedOnCategory(ProductDetailsRequest request);
}
