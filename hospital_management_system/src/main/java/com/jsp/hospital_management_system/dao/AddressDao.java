package com.jsp.hospital_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Address;
import com.jsp.hospital_management_system.repo.AddressRepo;

@Repository
public class AddressDao 
{
	@Autowired
	private AddressRepo addressRepo;
	
	public Address saveAddress(Address address)
	{
		return addressRepo.save(address);
	}
	
	public Address updateAddress(int aid,Address address)
	{
		if(addressRepo.findById(aid).isPresent())
		{
			address.setAid(aid);
			return addressRepo.save(address);
		}
		else
			return null;
	}
	
	public Address deleteAddress(int aid)
	{
		if(addressRepo.findById(aid).isPresent())
		{
			Address address = addressRepo.findById(aid).get();
			addressRepo.deleteById(aid);
			return address;
		}
		else
			return null;
	}
	
	public Address getAddressById(int aid)
	{
		if(addressRepo.findById(aid).isPresent())
			return addressRepo.findById(aid).get();
		else
			return null;
	}
}





















