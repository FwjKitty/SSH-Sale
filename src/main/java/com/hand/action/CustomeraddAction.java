package com.hand.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hand.model.CustomersInfo;
import com.hand.service.CustomersInfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class CustomeraddAction extends ActionSupport implements
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
	private String status;
	//private List<CustomersInfo> customers;

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
		System.out.println("进入addAction");
		System.out.println("customerName");
		customerService.add(customer);
	
		return "success";
	}
}
