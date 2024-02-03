package com.jsp.hospital_management_system.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.BranchDao;
import com.jsp.hospital_management_system.dao.EncounterDao;
import com.jsp.hospital_management_system.dao.PersonDao;
import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.dto.Encounter;
import com.jsp.hospital_management_system.dto.Person;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class EncounterService 
{
	@Autowired
	private EncounterDao encounterDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private BranchDao branchDao;
	
	ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
	
	public ResponseEntity<ResponseStructure<Encounter>>saveEncounter(Encounter encounter,int pid,int bid)
	{
		Person person = personDao.getPersonById(pid);
		Branch branch = branchDao.getBranchById(bid);
		
		encounter.setPerson(person);
		List<Branch> branches = new ArrayList<Branch>();
		branches.add(branch);
		encounter.setList(branches);
		
		responseStructure.setMessage("Encounter Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(encounterDao.saveEncounter(encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int eid,Encounter encounter,int bid)
	{
		Encounter dbEncounter = encounterDao.getEncounterById(eid);
		Branch branch = branchDao.getBranchById(bid);
		
		List<Branch> list = dbEncounter.getList();
		list.add(branch);
		encounter.setList(list);
		encounter.setPerson(dbEncounter.getPerson());
		
		responseStructure.setMessage("Encounter Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(encounterDao.updateEncounter(eid, encounter));
		return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int eid)
	{
		Encounter encounter = encounterDao.deleteEncounter(eid);
		if(encounter!=null)
		{
			responseStructure.setMessage("Encounter Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> getEncounterById(int eid)
	{
		Encounter encounter = encounterDao.getEncounterById(eid);
		if(encounter!=null)
		{
			responseStructure.setMessage("Encounter Found Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(responseStructure,HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}
}











