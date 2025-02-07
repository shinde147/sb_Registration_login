package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping("login")
	public String doLogin(@RequestBody String email, String password) {
	return	service.doLogin(email,password);
	}
	
	

}
