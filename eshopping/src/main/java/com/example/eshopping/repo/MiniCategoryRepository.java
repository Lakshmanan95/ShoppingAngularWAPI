package com.example.eshopping.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.eshopping.entity.MiniCategory;


@Repository
@Transactional
public interface MiniCategoryRepository  extends CrudRepository<MiniCategory, Long> {

	List<MiniCategory> findAll();
}
