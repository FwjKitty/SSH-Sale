package com.hand.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hand.dao.OriganizationDao;
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
	private Address address;
	private Payment payment;
	private Organization organization;
	private  Contactors contactors;
	
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
		 
		//Address address=new Address();
		System.out.println("进入详细action");
		System.out.println("名字"+customerName);
		System.out.println("国家"+country);
		address=customerService.getaddress(country);
		System.out.println(address.getAddressLine1());
		
		payment=customerService.getpayment(customerName);
		System.out.println(payment.getInvoiceGroup());
		
		System.out.println("bu="+businessManager);
		organization=customerService.getorganization(businessManager);
		System.out.println("action mark:"+organization.getMarketArea());
		
		contactors=customerService.getcontactors(customerName);
		System.out.println("action con mailFrom:"+contactors.getMailFrom());
		
		
		/*JsonArray jsonArray=new JsonArray();
		JsonObject jo=null;
	
			System.out.println("s");
			jo = new JsonObject();
			jo.addProperty("cou",address.getCountry());
			jo.addProperty("stat",address.getState());
			jo.addProperty("Coun", address.getCountry());
			jo.addProperty("ad1",address.getAddressLine1() );
			jo.addProperty("ad2", address.getAddressLine2());
			jo.addProperty("pos", address.getPostcode());
			jo.addProperty("port",address.getPortOfDestination());
			jo.addProperty("shk", address.getShippingMark());
			jo.addProperty("statu", address.getStatus());
			jo.addProperty("inD", address.getInactiveDate().toString());
			jsonArray.add(jo);
	
		try{
				HttpServletResponse response = ServletActionContext.getResponse();
				String addr = jsonArray.toString();
				System.out.println("json"+address);
				response.getWriter().write(addr);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		return "success";
	}
	
	public CustomersInfo getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
