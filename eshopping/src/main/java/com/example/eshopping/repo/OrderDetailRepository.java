package com.example.eshopping.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.eshopping.entity.OrderDetails;

public interface OrderDetailRepository extends CrudRepository<OrderDetails, Long> {

	OrderDetails findById(int id);
	
	List<OrderDetails> findByOrderId(int orderId);
}
