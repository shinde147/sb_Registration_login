package com.example.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class PasswordMyEncrypter {
	

	    public static String encryptMyPass(String password) {
	    	System.out.println(password);
	        if (password == null || password.isEmpty()) {
	            throw new IllegalArgumentException("Password cannot be null or empty");
	        }

	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] messageDigest = md.digest(password.getBytes());

	            BigInteger no = new BigInteger(1, messageDigest);
	            String hashtext = no.toString(16);
	            while (hashtext.length() < 32) {
	                hashtext = "0" + hashtext;
	            }
	            return hashtext;
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException(e);
	        }
	    }
	}



