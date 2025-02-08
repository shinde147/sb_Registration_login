package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequest;
import com.example.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping("/mylogin")
	   public String doLogin(@RequestBody LoginRequest loginRequest) {
        if (loginRequest.getEmail() == null || loginRequest.getEmail().isEmpty()) {
            return "Email cannot be null or empty";
        }
        if (loginRequest.getPassword() == null || loginRequest.getPassword().isEmpty()) {
            return "Password cannot be null or empty";
        }

        return service.doLogin(loginRequest.getEmail(), loginRequest.getPassword());
    }

}
