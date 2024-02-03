package com.jsp.hospital_management_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data	//used for Auto Generation of getters and setters (lambok)
public class Hospital 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hid;
	@NotNull(message = "Name Cannot be Null")
	@NotBlank(message = "Name Cannot be Blank")
	private String name;
	@NotEmpty(message = "Email Cannot be Null or Blank")
	private String email;
	@NotEmpty(message = "Gst Cannot be Null or Blank")
	private String gst;
}
