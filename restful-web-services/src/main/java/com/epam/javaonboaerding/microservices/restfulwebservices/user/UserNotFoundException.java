package com.epam.javaonboaerding.microservices.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}



}
