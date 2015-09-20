package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.ShowCustomerCodeDao;
import com.hand.model.CustomersInfo;

@Repository
@Transactional
public class ShowCustomerCodeDaoImpl implements ShowCustomerCodeDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	
	public List<CustomersInfo> getCustomersInfo() {
		System.out.println("cusImp");
		List<CustomersInfo> list=new ArrayList<CustomersInfo>();
		list= sessionFactory.getCurrentSession().createQuery("from CustomersInfo ").list();
		System.out.println(list);
		return  list;
	}


}
