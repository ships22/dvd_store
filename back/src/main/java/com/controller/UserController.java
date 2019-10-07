package com.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.model.UserModel;

import service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	UserService userService = new UserService();
	
	@GetMapping(produces = "application/json")
	@RequestMapping({"/validateLogin"})
	public User validateLogin() {
		return new User("user authenticated");
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public List<UserModel>getAllUser(){
		return userService.getAlluser();
	}
	
	@RequestMapping(value = "/userbyid/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<UserModel>getUserById(@PathVariable("id") int id){
		return userService.getUserbyId(id);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
	public void saveUser(@RequestBody UserModel user) {
		userService.saveUser(user.getFirstName(), user.getLastName(), user.getHouseNo(), user.getStreet(), user.getPostCode(), user.getCountry(), user.getIsAdmin(), user.getEmail());
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		userService.getAlluser(); 
	}

}
