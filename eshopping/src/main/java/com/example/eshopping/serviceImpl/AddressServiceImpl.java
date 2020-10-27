package com.example.eshopping.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.eshopping.entity.Address;
import com.example.eshopping.repo.AddressRepository;
import com.example.eshopping.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}
	
	@Override
	public Address getAddressById(int id) {
		return addressRepository.findById(id);
	}
	
	@Override
	public List<Address> getAddressByUserId(int userId){
		return addressRepository.findByUserId(userId);
	}
	
	@Override
	public int deleteAddress(int id) {
		return addressRepository.deleteById(id);
	}
}
