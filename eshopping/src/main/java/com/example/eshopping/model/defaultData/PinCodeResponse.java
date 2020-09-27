package com.example.eshopping.model.defaultData;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.Pincode;

public class PinCodeResponse extends BaseResponse{

	List<Pincode> pincode;

	public List<Pincode> getPincode() {
		return pincode;
	}

	public void setPincode(List<Pincode> pincode) {
		this.pincode = pincode;
	}
	
	
}
