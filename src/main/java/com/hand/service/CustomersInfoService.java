package com.hand.service;

import java.util.List;

import com.hand.model.Address;

import com.hand.model.CustomersInfo;


public interface CustomersInfoService {
	
	public CustomersInfo getCustomer(int customerId);
	
	//查找customer_name,customer_code,country,business_manager,business_assistant
	public List<CustomersInfo> findAllcustomers(String customerCode, String type, String customerName,String status,String groupCompany,String corporation);
	
	
	
	public int getCount();
	public List<CustomersInfo> queryByPage(int pageSize, int pageNow);
	public void update(CustomersInfo customer,int customerId);
	public void add(CustomersInfo customer);
	public void delete(CustomersInfo customer);
	
/*	public abstract Customer getCustomer(Customer customer);
	public abstract Customer getCustomerById(Short id);

	public abstract boolean register(Customer customer);

	public abstract List<Customer> getCustomers();
	
	public abstract int getCount();

	public abstract void delete(Customer customer);

	public abstract void update(Customer customer,short addressid);

	public abstract void add(Customer customer);

	public boolean isUser(Customer customer);
	public abstract List<Customer> getCustomersByPage(int pageSize, int pageNow);*/
}
