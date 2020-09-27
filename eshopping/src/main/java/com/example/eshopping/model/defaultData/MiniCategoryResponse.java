package com.example.eshopping.model.defaultData;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.MiniCategory;

public class MiniCategoryResponse extends BaseResponse {

	List<MiniCategory> miniCategory;

	public List<MiniCategory> getMiniCategory() {
		return miniCategory;
	}

	public void setMiniCategory(List<MiniCategory> miniCategory) {
		this.miniCategory = miniCategory;
	}
	
	
	
}
