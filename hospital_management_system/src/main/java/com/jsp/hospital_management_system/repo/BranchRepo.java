package com.jsp.hospital_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hospital_management_system.dto.Branch;
import com.jsp.hospital_management_system.dto.Hospital;

public interface BranchRepo extends JpaRepository<Branch, Integer>
{
	@Query("select b from Branch b where b.hospital=?1")
	public List<Branch> findBranchByHospitalId(Hospital hospital);
}
