package com.jsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.AddressDao;
import com.jsp.hospital_management_system.dto.Address;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class AddressService 
{
	@Autowired
	private AddressDao addressDao;

	ResponseStructure<Address> responseStructure = new ResponseStructure<>();

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		responseStructure.setMessage("Address Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddress(int aid,Address address)
	{
		Address dbAddress = addressDao.updateAddress(aid, address);
		if(dbAddress!=null)
		{
			responseStructure.setMessage("Address data Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbAddress);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		else
			return null;
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int aid)
	{
		Address address = addressDao.deleteAddress(aid);
		if(address != null)
		{
			responseStructure.setMessage("Address Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int aid)
	{
		Address address = addressDao.getAddressById(aid);
		if(address != null)
		{
			responseStructure.setMessage("Address Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(address);
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}
}



















