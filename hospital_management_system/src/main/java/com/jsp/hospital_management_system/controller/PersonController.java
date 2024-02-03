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

import com.jsp.hospital_management_system.dto.Person;
import com.jsp.hospital_management_system.service.PersonService;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/person")
public class PersonController 
{
	@Autowired
	private PersonService personService;
	
	@PostMapping
	@ApiOperation(value = "save person", notes = "save person api is used to save the details of person into db")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Saved")})
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid @RequestBody Person person)
	{
		return personService.savePerson(person);
	}
	
	@PutMapping
	@ApiOperation(value = "update person", notes = "update person api is used to update the details of person into db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Updated"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Person>> updatePerson(@Valid @RequestParam int pid,@RequestBody Person person)
	{
		return personService.updatePerson(pid, person);
	}
	
	@DeleteMapping
	@ApiOperation(value = "delete person", notes = "delete person api is used to delete the details of person in the db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Deleted"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@Valid @RequestParam int pid)
	{
		return personService.deletePerson(pid);
	}
	
	@GetMapping
	@ApiOperation(value = "get person by id", notes = "get person by id api is used to find the details of person based on id in the db")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "Successfully Found"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Person>> getPersonById(@Valid @RequestParam int pid)
	{
		return personService.getPersonById(pid);
	}
}

















