package com.example.eshopping.model.address;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.Address;

public class AddressResponse extends BaseResponse{

	Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
