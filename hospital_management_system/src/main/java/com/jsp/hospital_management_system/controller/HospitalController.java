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

import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.service.HospitalService;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/hospital")
public class HospitalController 
{
	@Autowired
	private HospitalService hospitalService;
	
	@PostMapping
	@ApiOperation(value = "save hospital", notes = "save hospital api is used to save the details of hospital into db")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Saved")})
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid @RequestBody Hospital hospital)
	{
		return hospitalService.saveHospital(hospital);
	}
	
	@PutMapping
	@ApiOperation(value = "update hospital", notes = "update hospital api is used to update the details of hospital into db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Updated"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@Valid @RequestParam int hid,@RequestBody Hospital hospital)
	{
		return hospitalService.updateHospital(hid, hospital);
	}
	
	@DeleteMapping
	@ApiOperation(value = "delete hospital", notes = "delete hospital api is used to delete the details of hospital in the db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Deleted"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@Valid @RequestParam int hid) {
		return hospitalService.deleteHospital(hid);
	}
	
	@GetMapping
	@ApiOperation(value = "get hospital by id", notes = "get hospital by id api is used to find the details of hospital based on id in the db")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "Successfully Found"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@Valid @RequestParam int hid) {
		return hospitalService.getHospitalById(hid);
	}
}








