package com.example.eshopping.service;

import java.util.List;

import com.example.eshopping.entity.Address;

public interface AddressService {

	public Address saveAddress(Address address);
	
	public Address getAddressById(int id);
	
	public List<Address> getAddressByUserId(int userId);
	
	public int deleteAddress(int id);
}
