package com.zmor.controller;

import com.zmor.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	@PutMapping
	public User updateUser(@RequestBody User user){
		System.out.println(user.getName());
		return user;
	}

	@DeleteMapping("/{id}")
	public List<User> deleteUesrById(@PathVariable Integer id){
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("aa");
		users.add(user);
		user = new User();
		user.setId(2);
		user.setName("bb");
		users.add(user);

		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()){
			if(iterator.next().getId()==id){
				iterator.remove();
			}
		}

		return  users;
	}

}
