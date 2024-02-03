package com.jsp.hospital_management_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	@NotEmpty(message = "City Cannot be Null or Blank")
	private String city;
	@NotEmpty(message = "State Cannot be Null or Blank")
	private String state;
	@NotNull(message = "Pincode is Mandatory")
	private long pincode;
}
