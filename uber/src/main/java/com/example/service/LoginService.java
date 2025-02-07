package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginDao;
import com.example.entity.User;

@Service
public class LoginService {

	@Autowired
	LoginDao dao;
	boolean check=false;
	public String doLogin(String email, String password) {
		
	boolean isEmailValidated=	EmailValidator.validateEmail(email);
	String encPass=	PasswordEncrypter.encryptMyPass(password);
	if (isEmailValidated) {
	check=	dao.doLogin(email,encPass);
	
	if (check) {
		return "login success..";
	}else {
		return "password is incorrect.";
	}
	
	}
	return " email is not correct..";
	
	
	}

}
