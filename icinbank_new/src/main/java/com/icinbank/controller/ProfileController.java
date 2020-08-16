package com.icinbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.icinbank.model.User;
import com.icinbank.model.UserDisplay;
import com.icinbank.service.ProfileService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

	@Autowired
	private ProfileService pservice;
	
	@PutMapping("/profile/update")
	public User updateUser(@RequestBody User user) {
		// TODO Auto-generated method stub
		return pservice.updateUser(user);
	}

	@GetMapping("/profile/{username}")
	public User getUser(@PathVariable("username") String username) {
		// TODO Auto-generated method stub
		return pservice.getUser(username);
	}
	
	@GetMapping("home/{username}")
	public UserDisplay userDisplay(@PathVariable("username")String username) {
		return pservice.userDisplay(username);
	}

}
