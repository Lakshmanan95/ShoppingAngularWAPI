package com.example.eshopping.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eshopping.entity.Cart;

@Repository
@Transactional
public interface CartRepository extends CrudRepository<Cart, Long>{

	List<Cart> findByUserId(int userId);
	
	Integer deleteById(Integer id);
	
	Cart findById(int id);
	
	Cart findByUserIdAndProductId(int userId, int productId);
}
