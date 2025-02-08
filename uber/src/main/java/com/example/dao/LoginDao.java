package com.example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public class LoginDao {

		    @Autowired
		    private SessionFactory sessionFactory;

		    public boolean doLogin(String email, String encryptedPassword) {
		        try (Session session = sessionFactory.openSession()) {
		            Criteria criteria = session.createCriteria(User.class);
		            criteria.add(Restrictions.eq("email", email));
		            criteria.add(Restrictions.eq("password", encryptedPassword));

		            List<User> result = criteria.list();

		            return !result.isEmpty();  // If there's a match, return true
		        }
		    
		    }
		
	}



