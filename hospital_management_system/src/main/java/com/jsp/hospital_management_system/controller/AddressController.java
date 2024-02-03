package com.jsp.hospital_management_system.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hospital_management_system.dto.Address;
import com.jsp.hospital_management_system.service.AddressService;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController 
{
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	@ApiOperation(value = "save address", notes = "save address api is used to save the address of hospital into db")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Saved")})
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody Address address)
	{
		return addressService.saveAddress(address);
	}
	
	@PutMapping
	@ApiOperation(value = "update address", notes = "update address api is used to update the address of hospital into db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Updated"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@Valid @RequestParam int aid,@RequestBody Address address)
	{
		return addressService.updateAddress(aid, address);
	}
	
	@DeleteMapping
	@ApiOperation(value = "delete address", notes = "delete address api is used to delete the address of hospital in the db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Deleted"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@Valid @RequestParam int aid)
	{
		return addressService.deleteAddress(aid);
	}
	
	@GetMapping
	@ApiOperation(value = "get address by id", notes = "get address by id api is used to find the address of hospital based on id in the db")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "Successfully Found"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@Valid @RequestParam int aid)
	{
		return addressService.getAddressById(aid);
	}
}
















