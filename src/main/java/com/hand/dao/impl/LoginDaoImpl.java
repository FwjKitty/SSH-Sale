package com.hand.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.LoginDao;
import com.hand.model.CustomersInfo;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{
	@Resource
	private SessionFactory sessionFactory;
	
	public CustomersInfo getCustomer(String firstName) {
		System.out.println("imo+"+firstName);
		return (CustomersInfo) sessionFactory.getCurrentSession()
				.createQuery("from CustomersInfo where customerName=?")
				.setParameter(0, firstName).uniqueResult();
	}


}
