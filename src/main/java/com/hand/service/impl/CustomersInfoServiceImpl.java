package com.hand.service.impl;

import java.io.UnsupportedEncodingException;
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
	public CustomersInfo getcustomer(int customerId){
		return customersInfoDao.getcustomer(customerId);
	}

	public Address getaddress(int customerId) {
		
		return customersInfoDao.getaddress(customerId);
	}
	public Payment getpayment(int customerId) {
		return customersInfoDao.getpayment(customerId);
	}
	public Organization getorganization(int customerId){
		
			return customersInfoDao.getorganization(customerId);
		
		
	}
/*	public Organization getorganization(String businessManager){
		try {
			return customersInfoDao.getorganization(new String(businessManager.getBytes("ISO-8859-1"),"UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}*/
	public Contactors getcontactors(int customerId){
		return customersInfoDao.getcontactors(customerId);
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
	public String update(int customerId,String customerName, String customerCode, String type, String groupCompany, String corporation,
			String country, String state, String city, String addressLine1, String addressLine2, String postcode,
			String portOfDestination, String shippingMark, String status, Date inactiveDate, String invoiceGroup,
			String currency, String paymentTerm, String priceTerm1, String priceTerm2, String priceTerm3,
			String markupName, String discountName, String marketArea, String businessManager, String businessAssistant,
			String mailFrom, String prePoMailTo, String poMailTo, String ocpiMailTo, String invPklistMailto) {
		return customersInfoDao.update(customerId,customerName,customerCode,type,groupCompany,corporation,country,
				state,city,addressLine1,addressLine2,postcode,portOfDestination,shippingMark,
				status,inactiveDate,invoiceGroup,currency,paymentTerm,priceTerm1,priceTerm2,
				priceTerm3,markupName,discountName,marketArea,businessManager,businessAssistant,
				mailFrom,prePoMailTo,poMailTo,ocpiMailTo,invPklistMailto);
		 
	}
	public boolean comfirm(int customerId){
		return customersInfoDao.comfirm(customerId);
	}
}
