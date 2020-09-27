package com.example.eshopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MiniCategory {

	@Id
	@GeneratedValue
	private int id;
	private String miniCategory;
	private int subCategoryId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMiniCategory() {
		return miniCategory;
	}
	public void setMiniCategory(String miniCategory) {
		this.miniCategory = miniCategory;
	}
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	
	
}
