package com.example.eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eshopping.common.BaseResponse;
import com.example.eshopping.common.CommonConstant;
import com.example.eshopping.entity.Address;
import com.example.eshopping.entity.Pincode;
import com.example.eshopping.model.address.AddressListResponse;
import com.example.eshopping.model.address.AddressRequest;
import com.example.eshopping.model.address.AddressResponse;
import com.example.eshopping.service.AddressService;
import com.example.eshopping.service.DefaultService;
import com.example.eshopping.util.EshoppingLogger;
import com.example.eshopping.util.JSONUtil;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@Autowired
	DefaultService defaultService;
	
	@PostMapping("/saveAndUpdateAddress")
	public AddressResponse saveAndUpdateAddress(@RequestBody AddressRequest request) {
		AddressResponse response = new AddressResponse();
		try {
			Address address = new Address();
			System.out.println(JSONUtil.toJson(request));
			Pincode pin = defaultService.getMatchCode(request.getAddress().getZipCode());
			if(pin == null) {
				response.setMessage("Please Enter valid Postal Code");
				response.setStatus(CommonConstant.ERROR);
				response.setStatusCode(01);
				return response;
			}
			if(request.getAddress().getId() != 0) {
				address = addressService.getAddressById(request.getAddress().getId());
			}
			address.setAddress1(request.getAddress().getAddress1());
			address.setAddress2(request.getAddress().getAddress2());
			address.setCity(request.getAddress().getCity());
			address.setState(request.getAddress().getState());
			address.setPhoneNumber(request.getAddress().getPhoneNumber());
			address.setUserId(request.getAddress().getUserId());
			address.setZipCode(request.getAddress().getZipCode());
			addressService.saveAddress(address);
		}
		catch(Exception e) {
			System.out.println(e);
			EshoppingLogger.logError(getClass(), "Add and Update Address Failed", e);
			response.setErrorCode("101");
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	@GetMapping("/getUserAddress/{id}")
	public AddressListResponse getUsersAddress(@PathVariable int id) {
		AddressListResponse response = new AddressListResponse();
		try {
			List<Address> address = addressService.getAddressByUserId(id);
			response.setAddress(address);
		}
		catch(Exception e) {
			System.out.println(e);
			EshoppingLogger.logError(getClass(), "GET Address By Failed", e);
			response.setErrorCode("101");
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	@GetMapping("/getAddressById/{id}")
	public AddressResponse getAddressById(@PathVariable int id) {
		AddressResponse response = new AddressResponse();
		try {
			Address address = addressService.getAddressById(id);
			response.setAddress(address);
		}
		catch(Exception e) {
			System.out.println(e);
			EshoppingLogger.logError(getClass(), "GET Address By Failed", e);
			response.setErrorCode("101");
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	} 
	
	@GetMapping("/deleteAddress/{id}")
	public BaseResponse deleteAddress(@PathVariable int id) {
		BaseResponse response = new BaseResponse();
		try {
			int delete = addressService.deleteAddress(id);
			response.setStatus(CommonConstant.SUCCESS);
		}
		catch(Exception e) {
			System.out.println(e);
			EshoppingLogger.logError(getClass(), "Delete Address By Failed", e);
			response.setErrorCode("101");
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	
}
