package com.epam.javaonboaerding.microservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	
	@Autowired
	private UserDaoService service;
	
	//http://localhost:8090/users
	//retrieve allusers
	@GetMapping("/users")
	List<User> retrieveAllUsers(){
		
		
		return service.findAll();
	}
	
	//http://localhost:8090/users/1
	//retrieve specific user
	@GetMapping("users/{id}")
	public User retrieveuser(@PathVariable int id){
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("Id -"+id);
		}
		return user;
	}
	
	
	
/*
    "timestamp": "2019-02-26T10:10:28.067+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Id -500",
    "trace": "com.epam.javaonboaerding.microservices.restfulwebservices.user.UserNotFoundException: Id -500\r\n\tat com.epam.javaonboaerding.microservices.restfulwebservices.user.UserResource.retrieveuser(UserResource.java:37)\r\n\tat sun.reflect.NativeMetho
*/	
	
/*	//created
	//input -details of user
	@PostMapping("/users")
	void createUser(@RequestBody User user)
	{
		User savedUser = service.save(user);
	}*/
	
	
	
	
	//  	localhost:8090/users
	//In post man
	/* {
	       
	        "name": "suresh new",
	        "birthdate": "2019-02-26T09:21:15.613+0000"
	    }*/
	
	
	
	
	//created
	//input -details of user
	@PostMapping("/users")
	ResponseEntity<Object> createUser(@Valid @RequestBody User user)
	{
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id){
		User user = service.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("Id -"+id);
		}
		return;
	}
}
