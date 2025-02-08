package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LoginDao;
import com.example.entity.User;



	@Service
	public class LoginService {

	    @Autowired
	    LoginDao dao;
	    int count =0;
	    
	    @Autowired
        User user;
	    
	    public String doLogin(String email, String password) {
	        // Print the password for debugging
	        System.out.println("Entered password in service: " + password);

	        boolean isEmailValidated = EmailValidator.validateEmail(email);
	       
	        if (user.getFailedAttempts()<user.getMaxAttempts()) {
	        	   if (isEmailValidated) {
	   	            boolean isPasswordCorrect = dao.doLogin(email, password);

	   	            if (isPasswordCorrect) {
	   	                return "Login success.";
	   	            } else {
	   	            	//ith liha ++
	   	                return "Password is incorrect.";
	   	            }
	   	        }

	   	        return "Email is not correct.";
	     
	    }else {
			return "plz try agaain later";
		}
	}
	
	}

	


