package com.example.eshopping.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.eshopping.entity.OrderFile;

public interface OrderFileRepository extends CrudRepository<OrderFile, Long>{

	List<OrderFile> findByOrderId(int orderId);
}
