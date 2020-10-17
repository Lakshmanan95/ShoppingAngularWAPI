package com.example.eshopping.model.product;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.Product;

public class ProductResponse extends BaseResponse {

	private Product product;
	private List<Product> productList;
	private int count;
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
