package com.hand.dao;

import java.util.List;

import com.hand.model.Address;

import com.hand.model.CustomersInfo;

public interface CustomersInfoDao {

	/*public abstract Customer getCustomer(Short id);

	public abstract Customer getCustomer(String username, String password);

	public abstract Customer getCustomer(String username);

	public abstract List<Customer> getCustomers();
	
	public abstract int getCount();

	public abstract List<Customer> queryByPage(int pageSize, int pageNow);

	public abstract void update(Customer customer, short addressid);

	public abstract void add(Customer customer);

	public abstract void save(Customer customer);

	public abstract void delete(Customer customer);
*/
	public CustomersInfo getCustomer(int customerId);
	//public List<String> getCustomers();
	//查找customer_name,customer_code,country,business_manager,business_assistant
	public List<CustomersInfo> findAllcustomers(String customerCode, String type, String customerName,String status,String groupCompany,String corporation);

	
	
	public int getCount();
	public List<CustomersInfo> queryByPage(int pageSize, int pageNow);
	public void update(CustomersInfo customer,int customerId);
	public void add(CustomersInfo customer);
	public void delete(CustomersInfo customer);
	List<Integer> queryIdByCodeAndTypeAndName(CustomersInfo customersInfo);
}