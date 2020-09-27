package com.example.eshopping.model.product;

public class ProductDetailsRequest {

	private String mainCategory;
	private String subCategory;
	private String miniCategory;
	private String location;
	private int pageNumber;
	private int noOfItems;
	
	public String getMainCategory() {
		return mainCategory;
	}
	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getMiniCategory() {
		return miniCategory;
	}
	public void setMiniCategory(String miniCategory) {
		this.miniCategory = miniCategory;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	
	
	
}
