package com.example.eshopping.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.eshopping.dao.ProductDAO;
import com.example.eshopping.entity.Product;
import com.example.eshopping.model.product.ProductDetailsRequest;
import com.example.eshopping.model.product.ProductResponse;

@Service
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public ProductResponse getProduct(String location, int sort){
		ProductResponse response = new ProductResponse();
		String query = "Select * from product";
//		if(location != null)
//			query+=" where location ='"+location+"' OR location = ";
		if(sort == 0) {
			query+=" order by price asc ";
		}
		else {
			query+=" order by price desc ";
		}
		query+=" limit 0,12";
		int count = jdbcTemplate.queryForObject("Select count(*) from product", Integer.class);
		List<Product> state = jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class));
		response.setProductList(state);
		response.setCount(count);
		return response;			
	}
	
	@Override
	public ProductResponse getProductBasedOnCategory(ProductDetailsRequest request){
		ProductResponse response = new ProductResponse();
		String query = "Select * from product ";
		String countQuery = "Select Count(*) from product ";
		if(request.getMainCategory() != null && !request.getMainCategory().isEmpty()) {
			query+= "where main_category ='"+request.getMainCategory()+"' ";
			countQuery+= "where main_category ='"+request.getMainCategory()+"' ";
		}
		if(request.getSubCategory() != null && !request.getSubCategory().isEmpty()) {
			query+= " and sub_category ='"+request.getSubCategory()+"' ";
			countQuery+= " and sub_category ='"+request.getSubCategory()+"' ";
		}
		if(request.getMiniCategory() != null && !request.getMiniCategory().isEmpty()) {
			query+= " and mini_category ='"+request.getMiniCategory()+"' ";
			countQuery+= " and mini_category ='"+request.getMiniCategory()+"' ";
		}
			
		if(request.getLocation() != null && !request.getLocation().isEmpty()) {
			query+= " and location ='"+request.getLocation()+"'";
			countQuery+= " and location ='"+request.getLocation()+"'";
		}
		if(request.getSort() == 0) {
			query+=" order by price asc ";
		}
		else {
			query+=" order by price desc ";
		}
		int startLimit = request.getPageNumber() * 1; 
		int endLimit = startLimit + request.getNoOfItems();
		
		query+=" limit "+startLimit+","+endLimit;
//		countQuery+=" limit "+startLimit+","+endLimit;
		System.out.println("query "+query);
		int count = jdbcTemplate.queryForObject(countQuery, Integer.class);
		System.out.println("count "+count);
		List<Product> state = jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class));
		response.setCount(count);
		response.setProductList(state);
		return response;			
	}

}
