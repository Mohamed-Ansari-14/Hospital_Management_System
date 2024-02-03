package com.jsp.hospital_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hospital_management_system.dao.PersonDao;
import com.jsp.hospital_management_system.dto.Person;
import com.jsp.hospital_management_system.exception.IdNotFoundException;
import com.jsp.hospital_management_system.util.ResponseStructure;

@Service
public class PersonService 
{
	@Autowired
	private PersonDao personDao;
	
	ResponseStructure<Person> responseStructure = new ResponseStructure<>();
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person)
	{
		responseStructure.setMessage("Person Added Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(personDao.savePerson(person));
		return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Person>> updatePerson(int pid,Person person)
	{
		Person dbPerson = personDao.updatePerson(pid, person);
		if(dbPerson!=null)
		{
			responseStructure.setMessage("Person Updated Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(dbPerson);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Person>> deletePerson(int pid)
	{
		Person person = personDao.deletePerson(pid);
		if(person!=null)
		{
			responseStructure.setMessage("Person Deleted Successfully");
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.OK);
		}
		else
			throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Person>> getPersonById(int pid)
	{
		Person person = personDao.getPersonById(pid);
		if(person!=null)
		{
			responseStructure.setMessage("Person Fetched Successfully");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(responseStructure,HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}
}















