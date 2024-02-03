package com.jsp.hospital_management_system.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.repo.HospitalRepo;

@Repository	//-->used for make connection with repo layer
public class HospitalDao 
{
	@Autowired
	private HospitalRepo hospitalRepo;
	
	public Hospital saveHospital(Hospital hospital)
	{
		return hospitalRepo.save(hospital);
	}
	
	public Hospital updateHospital(int hid,Hospital hospital)
	{
		if(hospitalRepo.findById(hid).isPresent())
		{
			hospital.setHid(hid);
			return hospitalRepo.save(hospital);
		}
		else
			return null;
	}
	
	public Hospital deleteHospital(int hid)
	{
		if(hospitalRepo.findById(hid).isPresent())
		{
			Hospital hospital = hospitalRepo.findById(hid).get();
			hospitalRepo.deleteById(hid);
			return hospital;
		}
		else
			return null;
	}
	
	public Hospital getHospitalById(int hid)
	{
		return hospitalRepo.findById(hid).get();
	}
	
	public List<Hospital> getAllHospitals() 
	{
		return hospitalRepo.findAll();
	}
	
	public Hospital findHospitalByEmail(String email)
	{
		return hospitalRepo.findHospitalByEmail(email);
	}
}
















