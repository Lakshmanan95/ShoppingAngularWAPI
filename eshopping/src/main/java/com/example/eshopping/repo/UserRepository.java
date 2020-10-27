package com.example.eshopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eshopping.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByEmailAndPassword(String email, String password);
	
	User findByUserName(String username);
	
	User findByEmail(String email);
	
	List<User> findAll();
	
	User findById(int id);
}
