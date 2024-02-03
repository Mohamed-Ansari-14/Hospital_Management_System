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

import com.jsp.hospital_management_system.dto.Encounter;
import com.jsp.hospital_management_system.service.EncounterService;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/encounter")
public class EncounterController 
{
	@Autowired
	private EncounterService encounterService;
	
	@PostMapping
	@ApiOperation(value = "save encounter", notes = "save encounter api is used to save the details of encounter into db")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Saved")})
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid @RequestBody Encounter encounter,@RequestParam int pid,@RequestParam int bid)
	{
		return encounterService.saveEncounter(encounter, pid, bid);
	}
	
	@PutMapping
	@ApiOperation(value = "update encounter", notes = "update encounter api is used to update the details of encounter into db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Updated"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@Valid @RequestParam int eid,@RequestBody Encounter encounter,@RequestParam int bid)
	{
		return encounterService.updateEncounter(eid, encounter, bid);
	}
	
	@DeleteMapping
	@ApiOperation(value = "delete encounter", notes = "delete encounter api is used to delete the details of encounter in the db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Deleted"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@Valid @RequestParam int eid)
	{
		return encounterService.deleteEncounter(eid);
	}
	
	@GetMapping
	@ApiOperation(value = "get encounter by id", notes = "get encounter by id api is used to find the details of encounter based on id in the db")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "Successfully Found"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(@Valid @RequestParam int eid)
	{
		return encounterService.getEncounterById(eid);
	}
}























