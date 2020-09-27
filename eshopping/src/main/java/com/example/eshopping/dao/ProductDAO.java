package com.example.eshopping.dao;

import java.util.List;

import com.example.eshopping.entity.Product;
import com.example.eshopping.model.product.ProductDetailsRequest;

public interface ProductDAO {

	public List<Product> getProduct(String location);
	
	public List<Product> getProductBasedOnCategory(ProductDetailsRequest request);
}
