package com.epam.javaonboaerding.microservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	//@RequestMapping(method=RequestMethod.GET path="/hello-world")
	@GetMapping( path="/hello-world")
	public String helloWorld()
	{
		return "Hello Suresh";
	}
	
	
	//hello world Bean not string 
	//@RequestMapping(method=RequestMethod.GET path="/hello-world")
		@GetMapping( path="/hello-worldbean")
		public HelloWorldBean helloWorldBean()
		{
			return new HelloWorldBean("Hello Suresh");
		}

		
		
		//hello world Bean not string 
		//@RequestMapping(method=RequestMethod.GET path="/hello-world")
		//http://localhost:8090/hello-worldbean/path-variable/hamsini
			@GetMapping( path="/hello-worldbean/path-variable/{name}")
			public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
			{
				return new HelloWorldBean(String.format("Hello  Suresh-ur daughter is %s",name));
			}


		@Override
		public String toString() {
			return "HelloWorldController [helloWorld()=" + helloWorld() + ", helloWorldBean()=" + helloWorldBean()
					+ "]";
		}

}
