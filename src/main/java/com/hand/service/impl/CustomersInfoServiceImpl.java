package com.hand.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.hand.dao.CustomersInfoDao;

import com.hand.model.Address;
import com.hand.model.Contactors;
import com.hand.model.CustomersInfo;
import com.hand.model.Organization;
import com.hand.model.Payment;
import com.hand.service.CustomersInfoService;

@Service
@Transactional
public class CustomersInfoServiceImpl implements CustomersInfoService {

	@Resource
	private CustomersInfoDao customersInfoDao;
	

	public CustomersInfoDao getCustomerInfoDao() {
		return customersInfoDao;
	}
	public void setCustomerInfoDao(CustomersInfoDao customerInfoDao) {
		this.customersInfoDao = customerInfoDao;
	}



	public List<String> getPageResult(int page, int pageSize) {
		return null;
		
	}



	public CustomersInfo getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CustomersInfo> findAllcustomers(String customerCode, String type, String customerName, String status,
			String groupCompany, String corporation) {
		return customersInfoDao.findAllcustomers(customerCode,type,customerName,status, groupCompany,corporation);
		
	}



	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<CustomersInfo> queryByPage(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(CustomersInfo customer, int customerId) {
		// TODO Auto-generated method stub
		
	}

	public void add(CustomersInfo customer) {
		customersInfoDao.add(customer);
		
	}

	public void delete(CustomersInfo customer) {
		// TODO Auto-generated method stub
		
	}

	public List<Integer> queryIdByCodeAndTypeAndName(String customerCode, String type, String customerName) {
		// TODO Auto-generated method stub
		return null;
	}
	public Address getaddress(String country) {
		
		return customersInfoDao.getaddress(country);
	}
	public Payment getpayment(String customerName) {
		return customersInfoDao.getpayment(customerName);
	}
	public Organization getorganization(String businessManager){
		return customersInfoDao.getorganization(businessManager);
	}
	public Contactors getcontactors(String customerName){
		return customersInfoDao.getcontactors(customerName);
	}
	public String add(String customerName, String customerCode, String type, String groupCompany, String corporation,
			String country, String state, String city, String addressLine1, String addressLine2, String postcode,
			String portOfDestination, String shippingMark, String status, Date inactiveDate, String invoiceGroup,
			String currency, String paymentTerm, String priceTerm1, String priceTerm2, String priceTerm3,
			String markupName, String discountName, String marketArea, String businessManager, String businessAssistant,
			String mailFrom, String prePoMailTo, String poMailTo, String ocpiMailTo, String invPklistMailto) {
		return customersInfoDao.add(customerName,customerCode,type,groupCompany,corporation,country,
				state,city,addressLine1,addressLine2,postcode,portOfDestination,shippingMark,
				status,inactiveDate,invoiceGroup,currency,paymentTerm,priceTerm1,priceTerm2,
				priceTerm3,markupName,discountName,marketArea,businessManager,businessAssistant,
				mailFrom,prePoMailTo,poMailTo,ocpiMailTo,invPklistMailto);
		 
	}
	public boolean comfirm(String status){
		return customersInfoDao.comfirm(status);
	}

	/*public Customer getCustomer(Customer customer) {

		return customerDao.getCustomer(customer.getFirstName());
	}

	public Customer getCustomerById(Short id) {

		return customerDao.getCustomer(id);
	}

	// @Override
	// public boolean register(Customer customer) {
	// return customerDao.save(customer);
	// }


	public List<Customer> getCustomers() {

		return customerDao.getCustomers();
	}

	public List<Customer> getCustomersByPage(int pageSize, int pageNow) {
		return customerDao.queryByPage(pageSize, pageNow);

	}

	public void delete(Customer customer) {

		customerDao.delete(customer);
	}


	public void update(Customer customer, short addressid) {

		customerDao.update(customer, addressid);
	}


	public void add(Customer customer) {

		customerDao.save(customer);
	}


	public boolean isUser(Customer customer) {
	
		if (customerDao.getCustomer(customer.getFirstName()) != null) {
			return true;
		}
		return false;
	}


	public boolean register(CustomersInfo customer) {
		// TODO Auto-generated method stub
		return false;
	}


	public int getCount() {
		int count=CustomersInfoDao.getCount();
		return count;
	}*/
}
