package com.example.eshopping.dao;

import java.util.List;

import com.example.eshopping.entity.Product;
import com.example.eshopping.model.product.ProductDetailsRequest;
import com.example.eshopping.model.product.ProductResponse;

public interface ProductDAO {

	public ProductResponse getProduct(String location, int sort);
	
	public ProductResponse getProductBasedOnCategory(ProductDetailsRequest request);
}
