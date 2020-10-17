package com.example.eshopping.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eshopping.entity.Pincode;

@Repository
public interface PincodeRepository extends CrudRepository<Pincode, Long>{

	List<Pincode> findAll();
	Pincode findByPinCode(String pinCode);
}
