package com.example.eshopping.model.address;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.Address;

public class AddressListResponse extends BaseResponse{

	List<Address> address;

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
}
