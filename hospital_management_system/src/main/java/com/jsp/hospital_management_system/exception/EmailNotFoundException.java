package com.jsp.hospital_management_system.exception;

public class EmailNotFoundException extends RuntimeException
{
	private String message = "Email Not Found";
	
	@Override
	public String getMessage() 
	{
		return message;
	}
	
	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EmailNotFoundException() {
		super();
	}
}
