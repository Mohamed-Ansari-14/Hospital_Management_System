package com.jsp.hospital_management_system.util;

import lombok.Data;

@Data
public class ResponseStructure<T>
{
	private String message;
	private int status;
	private T data;
}