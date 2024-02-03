package com.jsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.HospitalDao;
import com.jsp.hospital_management_system.dto.Hospital;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class HospitalService 
{
	@Autowired
	private HospitalDao hospitalDao;
	
	ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital)
	{
		responseStructure.setMessage("Hospital Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int hid,Hospital hospital)
	{
		Hospital dbHospital = hospitalDao.updateHospital(hid, hospital);
		if(dbHospital!=null)
		{
			responseStructure.setMessage("Hospital Data Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbHospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int hid)
	{
		Hospital hospital = hospitalDao.deleteHospital(hid);
		if(hospital != null)
		{
			responseStructure.setMessage("Hospital Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int hid)
	{
		Hospital hospital = hospitalDao.getHospitalById(hid);
		if(hospital != null)
		{
			responseStructure.setMessage("Hospital Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}
}










