package com.example.eshopping.model.defaultData;

import java.util.List;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.entity.Pincode;

public class PinCodeResponse extends BaseResponse{

	List<Pincode> pincode;
	boolean pincodeMatched;

	public List<Pincode> getPincode() {
		return pincode;
	}

	public void setPincode(List<Pincode> pincode) {
		this.pincode = pincode;
	}

	public boolean isPincodeMatched() {
		return pincodeMatched;
	}

	public void setPincodeMatched(boolean pincodeMatched) {
		this.pincodeMatched = pincodeMatched;
	}
	
	
}
