package com.example.eshopping.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eshopping.entity.Roles;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Long>{

	List<Roles> findAll();
}
