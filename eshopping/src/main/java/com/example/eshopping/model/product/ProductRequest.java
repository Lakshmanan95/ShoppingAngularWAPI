package com.example.eshopping.model.product;

import com.example.eshopping.entity.Product;

public class ProductRequest {

	private Product product;
	private String location;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
