package com.zmor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zmor.entities.User;

@RestController
@RequestMapping("/user")
public class UesrController {

	@PostMapping
	public User createUser(@RequestBody User user){
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		user.setId(1);
		return user;
	}
	
	@GetMapping
	public List<User> queryAll(){
		
		List<User> users = new ArrayList<User>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
	@GetMapping("/{id}")
	public User getOneUser(@PathVariable Integer id){
		User user= new User();
		System.out.println(id);
		user.setName("jj");
		user.setId(id);
		
		return user; 
	}
	
}
