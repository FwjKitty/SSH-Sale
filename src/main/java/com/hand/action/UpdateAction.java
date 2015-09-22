package com.hand.action;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hand.model.Address;
import com.hand.model.CustomersInfo;
import com.hand.service.CustomersInfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class UpdateAction extends ActionSupport implements
ModelDriven<CustomersInfo> {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private CustomersInfoService customerService;
	private CustomersInfo customer;
	private String customerName;
	private String customerCode;
	private String type;
	private String groupCompany;
	private String corporation;
	private int customerId;
	
	private Address address;
	
	private String country;
	private String state;
	private String city;
	private String addressLine1;
	private String addressLine2;
	private String postcode;
	private String portOfDestination;
	private String shippingMark;
	private String status;
	private Date inactiveDate; 
	
	private String invoiceGroup;
	private String currency;
	private String paymentTerm;
	private String priceTerm1;
	private String priceTerm2;
	private String priceTerm3;
	private String markupName;
	private String discountName;
	
	private String marketArea;
	private String businessManager;
	private String businessAssistant;
	
	private String mailFrom;
	private String prePoMailTo;
	private String poMailTo;
	private String ocpiMailTo;
	private String invPklistMailto;
	
	private String mag;
	
	
	//private List<CustomersInfo> customers;

	public String getMag() {
		return mag;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setMag(String mag) {
		this.mag = mag;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPortOfDestination() {
		return portOfDestination;
	}

	public void setPortOfDestination(String portOfDestination) {
		this.portOfDestination = portOfDestination;
	}

	public String getShippingMark() {
		return shippingMark;
	}

	public void setShippingMark(String shippingMark) {
		this.shippingMark = shippingMark;
	}

	public Date getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public String getInvoiceGroup() {
		return invoiceGroup;
	}

	public void setInvoiceGroup(String invoiceGroup) {
		this.invoiceGroup = invoiceGroup;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getPriceTerm1() {
		return priceTerm1;
	}

	public void setPriceTerm1(String priceTerm1) {
		this.priceTerm1 = priceTerm1;
	}

	public String getPriceTerm2() {
		return priceTerm2;
	}

	public void setPriceTerm2(String priceTerm2) {
		this.priceTerm2 = priceTerm2;
	}

	public String getPriceTerm3() {
		return priceTerm3;
	}

	public void setPriceTerm3(String priceTerm3) {
		this.priceTerm3 = priceTerm3;
	}

	public String getMarkupName() {
		return markupName;
	}

	public void setMarkupName(String markupName) {
		this.markupName = markupName;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getMarketArea() {
		return marketArea;
	}

	public void setMarketArea(String marketArea) {
		this.marketArea = marketArea;
	}

	public String getBusinessManager() {
		return businessManager;
	}

	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	public String getBusinessAssistant() {
		return businessAssistant;
	}

	public void setBusinessAssistant(String businessAssistant) {
		this.businessAssistant = businessAssistant;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getPrePoMailTo() {
		return prePoMailTo;
	}

	public void setPrePoMailTo(String prePoMailTo) {
		this.prePoMailTo = prePoMailTo;
	}

	public String getPoMailTo() {
		return poMailTo;
	}

	public void setPoMailTo(String poMailTo) {
		this.poMailTo = poMailTo;
	}

	public String getOcpiMailTo() {
		return ocpiMailTo;
	}

	public void setOcpiMailTo(String ocpiMailTo) {
		this.ocpiMailTo = ocpiMailTo;
	}

	public String getInvPklistMailto() {
		return invPklistMailto;
	}

	public void setInvPklistMailto(String invPklistMailto) {
		this.invPklistMailto = invPklistMailto;
	}

	public CustomersInfo getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomersInfo getCustomer() {
		return customer;
	}

	public void setCustomer(CustomersInfo customer) {
		this.customer = customer;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroupCompany() {
		return groupCompany;
	}

	public void setGroupCompany(String groupCompany) {
		this.groupCompany = groupCompany;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String execute() throws Exception{
		System.out.println("进入updateAction");
		System.out.println(customerName);
		System.out.println("客户id"+customerId);
		System.out.println("地址1"+addressLine1);
		System.out.println(country);
		System.out.println("status="+status);
		System.out.println("经理"+businessManager);
		System.out.println("市场"+marketArea);
		setMag("客户信息修改成功！");
		customerService.update(customerId,customerName,customerCode,type,groupCompany,corporation,country,
				state,city,addressLine1,addressLine2,postcode,portOfDestination,shippingMark,
				status,inactiveDate,invoiceGroup,currency,paymentTerm,priceTerm1,priceTerm2,
				priceTerm3,markupName,discountName,marketArea,businessManager,businessAssistant,
				mailFrom,prePoMailTo,poMailTo,ocpiMailTo,invPklistMailto);
		System.out.println("方法结束返回update action");
		return "success";
	}
}
