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

import com.jsp.hospital_management_system.dto.Medorder;
import com.jsp.hospital_management_system.service.MedorderService;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/medorder")
public class MedorderController 
{
	@Autowired
	private MedorderService medorderService;
	
	@PostMapping
	@ApiOperation(value = "save medorder", notes = "save medorder api is used to save the details of medorder into db")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Saved")})
	public ResponseEntity<ResponseStructure<Medorder>>saveMedorder(@Valid @RequestBody Medorder medorder,@RequestParam int eid)
	{
		return medorderService.saveMedorder(medorder,eid);
	}
	
	@PutMapping
	@ApiOperation(value = "update medorder", notes = "update medorder api is used to update the details of medorder into db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Updated"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Medorder>> updateMedorder(@Valid @RequestBody Medorder medorder,@RequestParam int id)
	{
		return medorderService.updateMedorder(id, medorder);
	}
	
	@DeleteMapping
	@ApiOperation(value = "delete medorder", notes = "delete medorder api is used to delete the details of medorder in the db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Deleted"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Medorder>> deleteMedorder(@Valid @RequestParam int id)
	{
		return medorderService.deleteMedorder(id);
	}
	
	@GetMapping
	@ApiOperation(value = "get medorder by id", notes = "get medorder by id api is used to find the details of medorder based on id in the db")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "Successfully Found"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Medorder>> getMedorderById(@Valid @RequestParam int id)
	{
		return medorderService.getMedorderById(id);
	}
}












