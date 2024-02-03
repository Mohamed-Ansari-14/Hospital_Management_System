package com.jsp.hospital_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.BranchDao;
import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class BranchService 
{
	@Autowired
	private BranchDao branchDao;
	
	ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch,int hid,int aid)
	{
		responseStructure.setMessage("Branch Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch,hid,aid));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int bid,Branch branch)
	{
		Branch dbBranch = branchDao.updateBranch(bid, branch);
		if(dbBranch != null)
		{
			responseStructure.setMessage("Branch Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbBranch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int bid)
	{
		Branch branch = branchDao.deleteBranch(bid);
		if(branch!=null)
		{
			responseStructure.setMessage("Branch Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int bid)
	{
		Branch branch = branchDao.getBranchById(bid);
		if(branch!=null)
		{
			responseStructure.setMessage("Branch Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospitalId(int hid)
	{
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Branch List Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(branchDao.findBranchByHospital(hid));
		return new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.FOUND);
	}
}














