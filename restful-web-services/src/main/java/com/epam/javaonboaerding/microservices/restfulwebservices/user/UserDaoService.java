package com.epam.javaonboaerding.microservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User>users = new ArrayList<>();
	
	private static int  userCount =3;
	
	static {
		users.add(new User(1,"suresh",new Date()));
		users.add(new User(2,"Nagesh",new Date()));
		users.add(new User(3,"Dheekshu",new Date()));
	}
	
	public List findAll()
	{
		return users;
	}
	
	public User save(User user) {
		if(null == user.getId()) {
			user.setId(++userCount);
		}
		
		users.add(user);
		
		return user;
	}

	
	public User findOne(int id) {
		
		for(User user :users)
		{
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
		
	}
	
	
public User deleteById(int id) {
	
/*	users.forEach(user-> {
		if(user.getId().equals(id)) {
			users.remove(id);
			return ;}
		
		});*/
		
	
		
		for(User user :users)
		{
			if(user.getId() == id) {
				return users.remove(id);
			}
		}
		return null;
		
	
}

}
