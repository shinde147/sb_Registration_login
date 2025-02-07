package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.RegisterService;

@RestController
@RequestMapping("user")
public class RegisterController {
	
	@Autowired
	RegisterService service;
	
	@PostMapping("register")
	public String doregistration(@RequestBody User user) {
		
		return service.doregistration(user);
	}
	

	
	

}
