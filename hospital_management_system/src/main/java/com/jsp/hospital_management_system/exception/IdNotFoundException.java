package com.jsp.hospital_management_system.exception;

public class IdNotFoundException extends RuntimeException
{
	private String message = "Id Not Found";
	
	@Override
	public String getMessage() 
	{
		return message;
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	public IdNotFoundException() {
		super();
	}
}
