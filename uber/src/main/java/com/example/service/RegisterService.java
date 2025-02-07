package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.RegisterDao;
import com.example.entity.User;



@Service
public class RegisterService {

	@Autowired
	RegisterDao dao;
	boolean isRegister=false;
	public String doregistration(User user) {
		user.setCreated(LocalDateTime.now());
		user.setModified(LocalDateTime.now());
		if (EmailValidator.validateEmail(user.getEmail())) {
			//1.pass dilay user ne
			//and encrypt password
			user.setPassword(PasswordEncrypter.encryptMyPass(user.getPassword()));
		  isRegister= dao.doregistration( user) ;
		}
		//boolean isRegistered= dao.doregistration( user) ;
		if (isRegister) {
			return "registration success";
		}else {
			return " registration failed";
		}
		
	}

	}


