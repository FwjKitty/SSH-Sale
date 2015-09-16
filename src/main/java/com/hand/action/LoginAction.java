package com.hand.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private String customer_name;
	public String execute(){
		ServletActionContext.getRequest().getSession().setAttribute("customer_name", customer_name);
		return "success";
	}
	
	public String exit(){
		ServletActionContext.getRequest().getSession().setAttribute("customer_name", null);
		return "exit";
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
}