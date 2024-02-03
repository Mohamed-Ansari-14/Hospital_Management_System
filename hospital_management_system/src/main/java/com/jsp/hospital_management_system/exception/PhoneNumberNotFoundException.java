package com.jsp.hospital_management_system.exception;

public class PhoneNumberNotFoundException extends RuntimeException
{
	private String message = "Phone Number Not Found";
	
	@Override
	public String getMessage() 
	{
		return message;
	}

	public PhoneNumberNotFoundException(String message) {
		super();
		this.message = message;
	}

	public PhoneNumberNotFoundException() {
		super();
	}
}
