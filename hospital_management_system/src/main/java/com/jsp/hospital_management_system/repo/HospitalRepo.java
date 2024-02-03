package com.jsp.hospital_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hospital_management_system.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer>
{
	@Query("select h from Hospital h where h.email=?1")
	public Hospital findHospitalByEmail(String email);
}
