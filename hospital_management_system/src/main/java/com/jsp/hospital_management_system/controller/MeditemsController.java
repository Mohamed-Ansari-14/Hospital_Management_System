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

import com.jsp.hospital_management_system.dto.Meditems;
import com.jsp.hospital_management_system.service.MeditemsService;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/meditems")
public class MeditemsController 
{
	@Autowired
	private MeditemsService meditemsService;
	
	@PostMapping
	@ApiOperation(value = "save meditems", notes = "save meditems api is used to save the details of meditems into db")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Saved")})
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(@Valid @RequestBody Meditems meditems,@RequestParam int id)
	{
		return meditemsService.saveMeditems(meditems, id);
	}
	
	@PutMapping
	@ApiOperation(value = "update meditems", notes = "update meditems api is used to update the details of meditems into db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Updated"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Meditems>> updateMeditems(@Valid @RequestBody Meditems meditems,@RequestParam int mid)
	{
		return meditemsService.updateMeditems(mid, meditems);
	}
	
	@DeleteMapping
	@ApiOperation(value = "delete meditems", notes = "delete meditems api is used to delete the details of meditems in the db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Deleted"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(@Valid @RequestParam int mid)
	{
		return meditemsService.deleteMeditems(mid);
	}
	
	@GetMapping
	@ApiOperation(value = "get meditems by id", notes = "get meditems by id api is used to find the details of meditems based on id in the db")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "Successfully Found"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Meditems>> getMeditemsById(@Valid @RequestParam int mid)
	{
		return meditemsService.getMeditemsById(mid);
	}
}









