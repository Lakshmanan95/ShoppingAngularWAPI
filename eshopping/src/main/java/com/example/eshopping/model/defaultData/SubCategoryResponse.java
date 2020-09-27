package com.example.eshopping.model.defaultData;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.SubCategory;

public class SubCategoryResponse extends BaseResponse {

	List<SubCategory> subCategory;

	public List<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}
	 
	
}
