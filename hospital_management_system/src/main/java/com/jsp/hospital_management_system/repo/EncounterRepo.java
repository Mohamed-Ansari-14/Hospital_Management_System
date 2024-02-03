package com.jsp.hospital_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hospital_management_system.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer>
{
	
}
