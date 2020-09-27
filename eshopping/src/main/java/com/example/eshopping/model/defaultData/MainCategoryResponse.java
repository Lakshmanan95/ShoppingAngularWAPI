package com.example.eshopping.model.defaultData;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.MainCategory;

public class MainCategoryResponse extends BaseResponse{

	List<MainCategory> mainCategory;

	public List<MainCategory> getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(List<MainCategory> mainCategory) {
		this.mainCategory = mainCategory;
	}
	
	
}
