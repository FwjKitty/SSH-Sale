package com.hand.dao;

import java.util.Date;
import java.util.List;

import com.hand.model.Address;
import com.hand.model.Contactors;
import com.hand.model.CustomersInfo;
import com.hand.model.Organization;
import com.hand.model.Payment;

public interface CustomersInfoDao {
	public List<CustomersInfo> findAllcustomers(String customerCode, String type, String customerName,String status,String groupCompany,String corporation);
	public CustomersInfo getcustomer(int customerId);
	public Address getaddress(int customerId);
	public Payment getpayment(int customerId);
	public Organization getorganization(int customerId);
	public Contactors getcontactors(int customerId);
	public String add(String customerName,String customerCode,String type,String groupCompany,String corporation,String country,
			String state,String city,String addressLine1,String addressLine2,String postcode,String portOfDestination,String shippingMark,
			String status,Date inactiveDate,String invoiceGroup,String currency,String paymentTerm,String priceTerm1,String priceTerm2,
			String priceTerm3,String markupName,String discountName,String marketArea,String businessManager,String businessAssistant,
			String mailFrom,String prePoMailTo,String poMailTo,String ocpiMailTo,String invPklistMailto);
	public String update(int customerId,String customerName,String customerCode,String type,String groupCompany,String corporation,String country,
			String state,String city,String addressLine1,String addressLine2,String postcode,String portOfDestination,String shippingMark,
			String status,Date inactiveDate,String invoiceGroup,String currency,String paymentTerm,String priceTerm1,String priceTerm2,
			String priceTerm3,String markupName,String discountName,String marketArea,String businessManager,String businessAssistant,
			String mailFrom,String prePoMailTo,String poMailTo,String ocpiMailTo,String invPklistMailto);
	
	
	public boolean comfirm(int customerId);
	
	public int getCount();
	public List<CustomersInfo> queryByPage(int pageSize, int pageNow);
	public void update(CustomersInfo customer,int customerId);
	public void add(CustomersInfo customer);
	public void delete(CustomersInfo customer);
	List<Integer> queryIdByCodeAndTypeAndName(CustomersInfo customersInfo);
}