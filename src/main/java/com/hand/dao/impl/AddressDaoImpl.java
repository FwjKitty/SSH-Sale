package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hand.dao.AddressDao;
import com.hand.model.Address;



@Repository
public class AddressDaoImpl implements AddressDao {

	@Resource
	private SessionFactory sessionFactory;


	
	//通过id找address
	
	public Address getAddress(Short id) {
		return  (Address) sessionFactory.getCurrentSession()
				.createQuery("from Address where addressId=?")
				.setParameter(0, id).list().get(0);
	}

	
	public List<Address> getAddress() {
		List<Address> list=new ArrayList<Address>();
		list= sessionFactory.openSession().createQuery("from Address ").list();
		return  list;
	}
	
	public void getAddress1(){
		List<Address> list=new ArrayList<Address>();
		list=(List<Address>) sessionFactory.getCurrentSession().createQuery("from Address ").list();
	}
	
	public Address getAddress(int customer_id) {
		Object address_id=null;
		 address_id=sessionFactory.getCurrentSession().createQuery("select address_id from CustomerInfo customer_id=?")
		.setParameter(0, customer_id).list().get(0);
		
		return  (Address) sessionFactory.getCurrentSession()
				.createQuery("from Address where address_id=?")
				.setParameter(0, address_id).list();
	}



	
	public List<Address> getAddress2() {
		List<Address> list=new ArrayList<Address>();
		list= sessionFactory.openSession().createQuery("from Address ").list();
		return  list;
	}



	public void update(Address address, int addressid) {
		
		
	}



	public void add(Address address) {
		// TODO Auto-generated method stub
		
	}



	public void delete(Address address) {
		// TODO Auto-generated method stub
		
	}
	
}
