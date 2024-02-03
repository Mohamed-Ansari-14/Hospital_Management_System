package com.jsp.hospital_management_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class Meditems 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	@NotEmpty(message = "Name Cannot be Null or Blank")
	private String name;
	private double cost;
	
	@ManyToOne
	private Medorder medorder;
}
