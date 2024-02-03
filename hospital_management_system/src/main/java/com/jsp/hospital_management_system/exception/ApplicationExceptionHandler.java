package com.jsp.hospital_management_system.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.hospital_management_system.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler
{
	ResponseStructure<String>responseStructure = new ResponseStructure<String>();
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException ex)
	{
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No ID Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFoundException(EmailNotFoundException ex)
	{
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Email Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PhoneNumberNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> phoneNumberNotFoundException(PhoneNumberNotFoundException ex)
	{
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Phone Number Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchElementException(NoSuchElementException ex)
	{
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setData("No Element Found");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCodeException status, WebRequest request) {
		List<ObjectError> list = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<>();
		for(ObjectError error:list)
		{
			String fieldName = ((FieldError)error).getField();
			String message = ((FieldError)error).getDefaultMessage();
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> handleConstraintViolationException(ConstraintViolationException ex)
	{
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setData("Fields Cannot be Null or Blank");
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}
}



















