package com.example.eshopping.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eshopping.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long >{

	Product findById(int id);
	
	Product findByProductNameAndLocation(String name, String location);
	
	List<Product> findByLocation(String location);
}
