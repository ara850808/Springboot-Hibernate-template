package com.user.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserRepository repository;
	
	@RequestMapping("/users/list")
	public Iterable<User> list() {
		return repository.findAll();
	}
	
	@RequestMapping("/users/add")
	public String add() {
		repository.save(new User("Tom", "User"));
		return "success";			 
	}
	
	@RequestMapping("/users/update")
	public String update() {
//		User user = new User();
//		user.setId((long)1);
//		user.setName("Tom");
//		user.setRole("Admin");		
//		repository.save(user);
		repository.setUserInfoById("Tom", "Admin", (long)9);		
		
		return "success";			 
	}
	
	@RequestMapping("/users/delete")
	public String delete() {
		repository.deleteById((long) 9);
		return "success";
	}
}
