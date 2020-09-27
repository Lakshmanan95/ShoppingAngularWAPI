package com.example.eshopping.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eshopping.entity.MainCategory;

@Repository
@Transactional
public interface MainCategoryRepository extends CrudRepository<MainCategory, Long>{
	
	List<MainCategory> findAll();
}
