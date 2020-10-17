package com.example.eshopping.service;

import java.util.List;

import com.example.eshopping.entity.MainCategory;
import com.example.eshopping.entity.MiniCategory;
import com.example.eshopping.entity.Pincode;
import com.example.eshopping.entity.SubCategory;

public interface DefaultService {

	public List<MainCategory> getMainCategory();
	
	public List<SubCategory> getSubCategory();
	
	public List<MiniCategory> getMiniCategory();
	
	public List<Pincode> getPincode();
	
	public Pincode getMatchCode(String pinCode);
}
