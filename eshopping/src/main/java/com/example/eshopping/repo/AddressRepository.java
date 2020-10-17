package com.example.eshopping.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eshopping.entity.Address;

@Repository
@Transactional
public interface AddressRepository extends CrudRepository<Address, Long> {

	Address findById(int id);
	List<Address> findByUserId(int userId);
	Integer deleteById(Integer id);
	
}
