package com.example.eshopping.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.eshopping.entity.OrderMaster;

public interface OrderMasterRepository extends CrudRepository<OrderMaster, Long>{

	List<OrderMaster> findByUserId(int userId);
	
	OrderMaster findById(int id);
}
