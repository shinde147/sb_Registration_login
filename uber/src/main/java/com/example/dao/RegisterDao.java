package com.example.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public class RegisterDao {

	@Autowired
	SessionFactory factory;
	public boolean doregistration(User user) {
		
		Session session = factory.openSession();
		session.save(user);
		session.beginTransaction().commit();
		return true;
	}
	public boolean login(String username, String password) {
		
		 Session session = null;
	        boolean isAuthenticated = false;
	        try {
	           
	            session = factory.openSession();
	            Criteria criteria = session.createCriteria(User.class);
	            
	            // Add restrictions for both username and password
	            criteria.add(Restrictions.eq("username", username));
	            criteria.add(Restrictions.eq("password", password)); 

	            // Check if a matching user exists
	            if (criteria.uniqueResult() != null) {
	                isAuthenticated = true;
	            }

	        } catch (Exception e) {
	           System.out.println("login failed..");
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }

	        return isAuthenticated;
	    }

		
		
		
	}


