package com.epam.javaonboaerding.microservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

//import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Resource;

//import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;




@RestController
public class UserJPAResource {

	
	@Autowired
	private UserDaoService service;
	

	@Autowired
	private UserRepository userRepository;
	
	//localhost:8090/jpa/users
	//retrieve allusers
	@GetMapping("/jpa/users")
	List<User> retrieveAllUsers(){
		
		
		return userRepository.findAll();
	}
	
	//http://localhost:8090/users/1
	//retrieve specific user
	@GetMapping("/jpa/users/{id}")
	/*public User  retrieveuser(@PathVariable int id){
		User user = userRepository.findById(id);
		if(! user.isPresent()) {
			throw new UserNotFoundException("Id -"+id);
		}
		
		//Resource<User> resource = new Resource<User>(user.get());
		//ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		//resource.add(linkTo.withRel("all-users"));

		// HATEOAS

		return user;
	}
	*/
	
	
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
	@PostMapping("jpa/users")
	ResponseEntity<Object> createUser(@RequestBody User user)
	{
		User savedUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
