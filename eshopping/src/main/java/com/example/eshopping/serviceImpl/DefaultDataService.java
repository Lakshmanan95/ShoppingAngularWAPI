package com.example.eshopping.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eshopping.entity.MainCategory;
import com.example.eshopping.entity.MiniCategory;
import com.example.eshopping.entity.Pincode;
import com.example.eshopping.entity.SubCategory;
import com.example.eshopping.repo.MainCategoryRepository;
import com.example.eshopping.repo.MiniCategoryRepository;
import com.example.eshopping.repo.PincodeRepository;
import com.example.eshopping.repo.SubCategoryRepository;
import com.example.eshopping.service.DefaultService;

@Service
public class DefaultDataService implements DefaultService{
	
	@Autowired
	MainCategoryRepository mainCategoryRepository;
	
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	@Autowired
	MiniCategoryRepository miniCategoryRepository;
	
	@Autowired
	PincodeRepository pincodeRepository;
	

	public List<MainCategory> getMainCategory(){
		return this.mainCategoryRepository.findAll();
	}
	
	public List<SubCategory> getSubCategory(){
		return this.subCategoryRepository.findAll();
	}
	
	public List<MiniCategory> getMiniCategory(){
		return this.miniCategoryRepository.findAll();
	}
	
	public List<Pincode> getPincode(){
		return this.pincodeRepository.findAll();
	}
	
	public Pincode getMatchCode(String pinCode) {
		return this.pincodeRepository.findByPinCode(pinCode);
	}
}
