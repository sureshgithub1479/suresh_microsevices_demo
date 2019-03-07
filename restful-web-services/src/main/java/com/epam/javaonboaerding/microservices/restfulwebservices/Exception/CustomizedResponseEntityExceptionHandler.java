package com.epam.javaonboaerding.microservices.restfulwebservices.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.epam.javaonboaerding.microservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	ResponseEntity<Object> handleAllExcptions(Exception ex,WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	ResponseEntity<Object> handleUserNotFoundException(Exception ex,WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
			ExceptionResponse response = new ExceptionResponse(new Date(),"Validation failed",ex.getBindingResult().toString());
		return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
	}
}
