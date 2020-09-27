package com.example.eshopping.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eshopping.entity.MainCategory;
import com.example.eshopping.entity.SubCategory;

@Repository
@Transactional
public interface SubCategoryRepository  extends CrudRepository<SubCategory, Long> {

	List<SubCategory> findAll();
}
