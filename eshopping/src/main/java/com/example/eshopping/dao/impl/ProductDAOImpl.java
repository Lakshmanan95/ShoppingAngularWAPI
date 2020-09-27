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

@Service
@Transactional
public class ProductDAOImpl implements ProductDAO{

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getProduct(String location){
		String query = "Select * from product";
		if(location != null)
			query+=" where location ='"+location+"'";
		query+=" limit 0,12";
		List<Product> state = jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class));
		return state;			
	}
	
	@Override
	public List<Product> getProductBasedOnCategory(ProductDetailsRequest request){
		String query = "Select * from product ";
		if(request.getMainCategory() != null && !request.getMainCategory().isEmpty())
			query+= "where main_category ='"+request.getMainCategory()+"' and ";
		if(request.getSubCategory() != null && !request.getSubCategory().isEmpty())
			query+= " sub_category ='"+request.getSubCategory()+"' and ";
		if(request.getMiniCategory() != null && !request.getMiniCategory().isEmpty())
			query+= " mini_category ='"+request.getMiniCategory()+"' and ";
		if(request.getLocation() != null && !request.getLocation().isEmpty())
			query+= " location ='"+request.getLocation()+"'";
		int startLimit = request.getPageNumber() * 1; 
		int endLimit = startLimit + request.getNoOfItems();
		
		query+=" limit "+startLimit+","+endLimit;
		System.out.println("query "+query);
		List<Product> state = jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class));
		return state;			
	}

}
