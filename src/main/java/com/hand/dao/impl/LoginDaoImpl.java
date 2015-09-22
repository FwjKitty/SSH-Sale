package com.hand.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.LoginDao;
import com.hand.model.CustomersInfo;
import com.hand.model.User;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{
	@Resource
	private SessionFactory sessionFactory;
	
	public User getCustomer(String firstName,String password) {
			
		return (User) sessionFactory.getCurrentSession()
				.createQuery("from User where username=? and password=?")
				.setParameter(0, firstName).setParameter(1, password).uniqueResult();
	}


}
