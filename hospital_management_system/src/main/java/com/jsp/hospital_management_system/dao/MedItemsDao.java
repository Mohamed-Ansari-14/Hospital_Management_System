package com.jsp.hospital_management_system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hospital_management_system.dto.Meditems;
import com.jsp.hospital_management_system.dto.Medorder;
import com.jsp.hospital_management_system.repo.MeditemsRepo;

@Repository
public class MedItemsDao 
{
	@Autowired
	private MeditemsRepo meditemsRepo;
	
	@Autowired
	private MedorderDao medorderDao;
	
	public Meditems saveMeditems(Meditems meditems,int id)
	{
		Medorder medorder = medorderDao.getMedorderById(id);
		meditems.setMedorder(medorder);
		return meditemsRepo.save(meditems);
	}
	
	public Meditems updateMeditems(int mid,Meditems meditems)
	{
		if(meditemsRepo.findById(mid).isPresent())
		{
			meditems.setMid(mid);
			return meditemsRepo.save(meditems);
		}
		else
			return null;
	}
	
	public Meditems deleteMeditems(int mid)
	{
		if(meditemsRepo.findById(mid).isPresent())
		{
			Meditems meditems = meditemsRepo.findById(mid).get();
			meditemsRepo.deleteById(mid);
			return meditems;
		}
		else
			return null;
	}
	
	public Meditems getMeditemsById(int mid)
	{
		return meditemsRepo.findById(mid).get();
	}
}














