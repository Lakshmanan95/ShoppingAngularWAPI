package com.example.eshopping.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eshopping.dao.ProductDAO;
import com.example.eshopping.entity.Product;
import com.example.eshopping.model.product.ProductDetailsRequest;
import com.example.eshopping.model.product.ProductResponse;
import com.example.eshopping.repo.ProductRepository;
import com.example.eshopping.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	@Override
	public Product getProductById(int id) {
		return this.productRepository.findById(id);
	}
	
	@Override
	public Product getProductByNameAndProductLocation(String name, String location) {
		return this.productRepository.findByProductNameAndLocation(name, location);
	}
	
	@Override
	public ProductResponse getProductByLocation(String location, int sort){
		return this.productDAO.getProduct(location, sort);
	}
	
	@Override
	public List<Product> getProduct(){
		return (List<Product>) this.productRepository.findAll();
	}
	
	@Override
	public ProductResponse getProductBasedOnCategory(ProductDetailsRequest request){
		return this.productDAO.getProductBasedOnCategory(request);
	}
	
}
