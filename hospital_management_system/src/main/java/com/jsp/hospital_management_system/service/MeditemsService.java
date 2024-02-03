package com.jsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.MedItemsDao;
import com.jsp.hospital_management_system.dto.Meditems;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class MeditemsService 
{
	@Autowired
	private MedItemsDao medItemsDao;
	
	ResponseStructure<Meditems> responseStructure = new ResponseStructure<Meditems>();
	
	public ResponseEntity<ResponseStructure<Meditems>> saveMeditems(Meditems meditems,int id)
	{
		responseStructure.setMessage("Meditems Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(medItemsDao.saveMeditems(meditems, id));
		return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Meditems>> updateMeditems(int mid,Meditems meditems)
	{
		Meditems dbMeditems = medItemsDao.getMeditemsById(mid);
		meditems.setMedorder(dbMeditems.getMedorder());
		Meditems meditems2 = medItemsDao.updateMeditems(mid, dbMeditems);
		if(meditems2!=null)
		{
			responseStructure.setMessage("Meditems Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(meditems2);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Meditems>> deleteMeditems(int mid)
	{
		Meditems meditems = medItemsDao.deleteMeditems(mid);
		if(meditems!=null)
		{
			responseStructure.setMessage("Meditems Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Meditems>> getMeditemsById(int mid)
	{
		Meditems meditems = medItemsDao.getMeditemsById(mid);
		if(meditems!=null)
		{
			responseStructure.setMessage("Meditems Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(meditems);
			return new ResponseEntity<ResponseStructure<Meditems>>(responseStructure,HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}
}







