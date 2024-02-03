package com.jsp.hospital_management_system.controller;

import java.util.List;

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

import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.service.BranchService;
import com.jsp.hospital_management_system.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/branch")
public class BranchController 
{
	@Autowired
	private BranchService branchService;
	
	@PostMapping
	@ApiOperation(value = "save branch", notes = "save branch api is used to save the branch of hospital into db")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Successfully Saved")})
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@javax.validation.Valid @RequestBody Branch branch,@RequestParam int hid,@RequestParam int aid )
	{
		return branchService.saveBranch(branch, hid, aid);
	}
	
	@PutMapping
	@ApiOperation(value = "update branch", notes = "update branch api is used to update the branch of hospital into db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Updated"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@Valid @RequestParam int bid,@RequestBody Branch branch)
	{
		return branchService.updateBranch(bid, branch);
	}
	
	@DeleteMapping
	@ApiOperation(value = "delete branch", notes = "delete branch api is used to delete the branch of hospital in the db")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "Successfully Deleted"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@Valid @RequestParam int bid)
	{
		return branchService.deleteBranch(bid);
	}
	
	@GetMapping
	@ApiOperation(value = "get branch by id", notes = "get branch by id api is used to find the branch of hospital based on id in the db")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "Successfully Found"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@Valid @RequestParam int bid)
	{
		return branchService.getBranchById(bid);
	}
	
	@GetMapping("/branchByHospital")
	@ApiOperation(value = "get branch by hospital", notes = "get branch by hospital api is used to find the branch of hospital based on hospital id in the db")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "Successfully Found"),@ApiResponse(code = 404,message = "id not found for hospital")})
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospitalId(@Valid @RequestParam int hid)
	{
		return branchService.getBranchByHospitalId(hid);
	}
}























