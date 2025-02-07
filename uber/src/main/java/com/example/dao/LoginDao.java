package com.example.dao;

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
	SessionFactory factory;
	public boolean doLogin(String email, String encPass) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", encPass));
		
		User user=(User)criteria.uniqueResult();//unique value return jith hya donhi goshti match hotil
		if (user!=null) {
			return true;
		}else {
			return false;
		}
			
			
			
		
		
		
	}

}
