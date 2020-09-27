package com.example.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eshopping.common.CommonConstant;
import com.example.eshopping.entity.MainCategory;
import com.example.eshopping.entity.MiniCategory;
import com.example.eshopping.entity.Pincode;
import com.example.eshopping.entity.SubCategory;
import com.example.eshopping.model.defaultData.MainCategoryResponse;
import com.example.eshopping.model.defaultData.MiniCategoryResponse;
import com.example.eshopping.model.defaultData.PinCodeResponse;
import com.example.eshopping.model.defaultData.SubCategoryResponse;
import com.example.eshopping.service.DefaultService;

@RestController
@RequestMapping("/defaultData")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DefaultDataController {

	@Autowired
	DefaultService defaultService;
	
	@GetMapping("/mainCategory")
	public MainCategoryResponse getMainCategory() {
		MainCategoryResponse response = new MainCategoryResponse();
		try {
			List<MainCategory> mainCategory = defaultService.getMainCategory();
			response.setMainCategory(mainCategory);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	@GetMapping("/subCategory")
	public SubCategoryResponse getSubCategory() {
		SubCategoryResponse response = new SubCategoryResponse();
		try {
			List<SubCategory> mainCategory = defaultService.getSubCategory();
			response.setSubCategory(mainCategory);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	@GetMapping("/miniCategory")
	public MiniCategoryResponse getMiniCategory() {
		MiniCategoryResponse response = new MiniCategoryResponse();
		try {
			List<MiniCategory> mainCategory = defaultService.getMiniCategory();
			response.setMiniCategory(mainCategory);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	@GetMapping("/getPincode")
	public PinCodeResponse getPinCode() {
		PinCodeResponse response = new PinCodeResponse();
		try {
			List<Pincode> pinCode = defaultService.getPincode();
			response.setPincode(pinCode);
		}
		catch(Exception e) {
			System.out.println(e);
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
}
