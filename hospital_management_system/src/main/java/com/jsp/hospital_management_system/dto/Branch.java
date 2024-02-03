package com.jsp.hospital_management_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data	//used for Auto Generation of getters and setters (lombok)
public class Branch 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	@NotEmpty(message = "Name Cannot be null or blank")
	private String name;
	@NotNull(message = "Phone Cannot be null or blank")
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long phone;
	@NotEmpty(message = "Manager Cannot be null or blank")
	private String manager;
	
	@ManyToOne
	private Hospital hospital;
	
	@OneToOne
	private Address address;
}
