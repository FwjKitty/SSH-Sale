package com.hand.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;


import com.hand.model.Address;
import com.hand.model.Contactors;
import com.hand.model.CustomersInfo;
import com.hand.model.Organization;
import com.hand.model.Payment;
import com.hand.service.CustomersInfoService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class CustomerDetailedAction extends ActionSupport implements
ModelDriven<CustomersInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private CustomersInfoService customerService;
	private String customerName;
	private CustomersInfo customer;
	private Address address;
	private Payment payment;
	private Organization organization;
	private  Contactors contactors;
	private int customerId;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Contactors getContactors() {
		return contactors;
	}
	public void setContactors(Contactors contactors) {
		this.contactors = contactors;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public CustomersInfo getCustomer() {
		return customer;
	}
	public void setCustomer(CustomersInfo customer) {
		this.customer = customer;
	}

	public String country;
	private String businessManager;
	public String getBusinessManager() {
		return businessManager;
	}
	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String execute() throws Exception{
		System.out.println("进入详情Action");
		/*System.out.println("经理"+new String(businessManager.getBytes("ISO-8859-1"),"UTF-8"));
		String bu=new String(businessManager.getBytes("ISO-8859-1"),"UTF-8");*/
		customer=customerService.getcustomer(customerId);
		address=customerService.getaddress(customerId);
		payment=customerService.getpayment(customerId);	
		organization=customerService.getorganization(customerId);
		contactors=customerService.getcontactors(customerId);
		System.out.println("简称"+customer.getCustomerCode());
		System.out.println("详情查询结束");
		return "success";
		
	}
	
	public CustomersInfo getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
