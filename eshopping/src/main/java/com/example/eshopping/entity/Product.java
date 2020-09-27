package com.example.eshopping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	private String weight;
	private double price;
	private int quantity;
	private boolean externalShop;
	private boolean active;
	private String mainCategory;
	private String category;
	private String subCategory;
	private String productImage;
	private int productAddUserId;
	private String description;
	private String location;
	private String createdDate;
	private double offerPrice;
	private String title;
	private String brand;
	private String defaultTimeSlot;
	private int minVariant;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isExternalShop() {
		return externalShop;
	}
	public void setExternalShop(boolean externalShop) {
		this.externalShop = externalShop;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getMainCategory() {
		return mainCategory;
	}
	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getProductAddUserId() {
		return productAddUserId;
	}
	public void setProductAddUserId(int productAddUserId) {
		this.productAddUserId = productAddUserId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setProductLocation(String location) {
		this.location = location;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(double offerPrice) {
		this.offerPrice = offerPrice;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDefaultTimeSlot() {
		return defaultTimeSlot;
	}
	public void setDefaultTimeSlot(String defaultTimeSlot) {
		this.defaultTimeSlot = defaultTimeSlot;
	}
	public int getMinVariant() {
		return minVariant;
	}
	public void setMinVariant(int minVariant) {
		this.minVariant = minVariant;
	}
	
	
	
	
	
}
