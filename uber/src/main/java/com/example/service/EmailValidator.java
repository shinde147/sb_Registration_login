package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator {
	
	public static boolean validateEmail(String email) {
	if (email.contains("@") && email.endsWith(".com")  || email.endsWith(".edu")) {
		return true;
	} else {
		return false;
	}

}
}