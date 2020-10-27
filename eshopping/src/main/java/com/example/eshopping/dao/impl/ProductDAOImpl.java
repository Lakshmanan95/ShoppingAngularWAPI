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
		
		String query = "select * from product p where p.EXTERNAL_SHOP = 0 ";
		if(location != null) {
			query+=" or location='"+location+"'";
		}
		if(sort == 0) {
			query+=" order by price asc ";
		}
		else {
			query+=" order by price desc ";
		}
		System.out.println("Count "+query);
		String queryToCount = "select count(*) from product p where p.EXTERNAL_SHOP = 0 ";
		query+=" limit 0,12";
		int count = jdbcTemplate.queryForObject(queryToCount, Integer.class);
		List<Product> state = jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class));
		response.setProductList(state);
		response.setCount(count);
		return response;			
	}
	
	@Override
	public ProductResponse getProductBasedOnCategory(ProductDetailsRequest request){
		ProductResponse response = new ProductResponse();
		String query = "select * from product p where (EXTERNAL_SHOP = 0 or location='"+request.getLocation()+"')";
		String countQuery = "select count(*) from product p where (EXTERNAL_SHOP = 0 or location='"+request.getLocation()+"')";
		if(request.getMainCategory() != null && !request.getMainCategory().isEmpty()) {
			query+= " and main_category ='"+request.getMainCategory()+"' ";
			countQuery+= " and main_category ='"+request.getMainCategory()+"' ";
		}
		
		if(request.getSubCategory() != null && !request.getSubCategory().isEmpty()) {
			query+= " and sub_category ='"+request.getSubCategory()+"' ";
			countQuery+= " and sub_category ='"+request.getSubCategory()+"' ";
		}
		if(request.getMiniCategory() != null && !request.getMiniCategory().isEmpty()) {
			query+= " and mini_category ='"+request.getMiniCategory()+"' ";
			countQuery+= " and mini_category ='"+request.getMiniCategory()+"' ";
		}
		
		if(request.getSort() == 0) {
			query+=" order by price asc ";
		}
		else {
			query+=" order by price desc ";
		}
		
		int startLimit = request.getPageNumber() - 1;
		if(startLimit >= 1) {
			startLimit = (request.getPageNumber()-1) * request.getNoOfItems();
			startLimit+=1;
		}
		
		query+=" limit "+startLimit+","+request.getNoOfItems();
		System.out.println("query "+query);
		int count = jdbcTemplate.queryForObject(countQuery, Integer.class);
		List<Product> state = jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class));
		response.setCount(count);
		response.setProductList(state);
		return response;			
	}

}
