package com.jsp.hospital_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Encounter;
import com.jsp.hospital_management_system.repo.EncounterRepo;

@Repository
public class EncounterDao 
{
	@Autowired
	private EncounterRepo encounterRepo;
	
	public Encounter saveEncounter(Encounter encounter)
	{
		return encounterRepo.save(encounter);
	}
	
	public Encounter updateEncounter(int eid,Encounter encounter)
	{
		if(encounterRepo.findById(eid).isPresent())
		{
			encounter.setEid(eid);
			return encounterRepo.save(encounter);
		}
		else
			return null;
	}
	
	public Encounter deleteEncounter(int eid)
	{
		if(encounterRepo.findById(eid).isPresent())
		{
			Encounter encounter = encounterRepo.findById(eid).get();
			encounterRepo.deleteById(eid);
			return encounter;
		}
		else
			return null;
	}
	
	public Encounter getEncounterById(int eid)
	{
		if(encounterRepo.findById(eid).isPresent())
			return encounterRepo.findById(eid).get();
		else
			return null;
	}
}







