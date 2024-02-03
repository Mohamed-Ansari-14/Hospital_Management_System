package com.jsp.hospital_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Address;
import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.repo.BranchRepo;

@Repository
public class BranchDao 
{
	@Autowired
	private BranchRepo branchRepo;
	
	@Autowired
	private HospitalDao hospitalDao;
	
	@Autowired
	private AddressDao addressDao;
	
	public Branch saveBranch(Branch branch,int hid,int aid)
	{
		Hospital hospital = hospitalDao.getHospitalById(hid);
		branch.setHospital(hospital);
		Address address = addressDao.getAddressById(aid);
		branch.setAddress(address);
		return branchRepo.save(branch);
	}
	
	public Branch updateBranch(int bid,Branch branch)
	{
		Branch branch2 = branchRepo.findById(bid).get();
		if(branch2!=null)
		{
			branch.setBid(bid);
			branch.setHospital(branch2.getHospital());
			branch.setAddress(branch2.getAddress());
			return branchRepo.save(branch);
		}
		else
			return null;
	}
	
	public Branch deleteBranch(int bid)
	{
		if(branchRepo.findById(bid).isPresent())
		{
			Branch branch = branchRepo.findById(bid).get();
			branchRepo.deleteById(bid);
			return branch;
		}
		else
			return null;
	}
	
	public Branch getBranchById(int bid)
	{
		if(branchRepo.findById(bid).isPresent())
			return branchRepo.findById(bid).get();
		else
			return null;
	}
	
	public List<Branch> findBranchByHospital(int hid)
	{
		Hospital hospital = hospitalDao.getHospitalById(hid);
		return branchRepo.findBranchByHospitalId(hospital);
	}
}

















