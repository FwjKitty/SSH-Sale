package com.hand.dao;

import java.util.Date;
import java.util.List;

import com.hand.model.Address;
import com.hand.model.Contactors;
import com.hand.model.CustomersInfo;
import com.hand.model.Organization;
import com.hand.model.Payment;

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
	/*public CustomersInfo getCustomer(String customerName);*/
	//public List<String> getCustomers();
	//查找customer_name,customer_code,country,business_manager,business_assistant
	public List<CustomersInfo> findAllcustomers(String customerCode, String type, String customerName,String status,String groupCompany,String corporation);
	public Address getaddress(String country);
	public Payment getpayment(String customerName);
	public Organization getorganization(String businessManager);
	public Contactors getcontactors(String customerName);
	public String add(String customerName,String customerCode,String type,String groupCompany,String corporation,String country,
			String state,String city,String addressLine1,String addressLine2,String postcode,String portOfDestination,String shippingMark,
			String status,Date inactiveDate,String invoiceGroup,String currency,String paymentTerm,String priceTerm1,String priceTerm2,
			String priceTerm3,String markupName,String discountName,String marketArea,String businessManager,String businessAssistant,
			String mailFrom,String prePoMailTo,String poMailTo,String ocpiMailTo,String invPklistMailto);
	
	public boolean comfirm(String status);
	
	public int getCount();
	public List<CustomersInfo> queryByPage(int pageSize, int pageNow);
	public void update(CustomersInfo customer,int customerId);
	public void add(CustomersInfo customer);
	public void delete(CustomersInfo customer);
	List<Integer> queryIdByCodeAndTypeAndName(CustomersInfo customersInfo);
	List<CustomersInfo> queryCustomerCodes();
	
}