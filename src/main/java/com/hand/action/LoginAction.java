package com.hand.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hand.dao.LoginDao;
import com.hand.model.CustomersInfo;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	@Resource
	private LoginDao loginDao;
	private CustomersInfo customerInfo;
	private String customer_name;
	public String login(){
		
		System.out.println("login");
		if (loginDao.getCustomer(customer_name) != null) {
			if (ServletActionContext.getRequest().getSession()
					.getAttribute("username") == null) {
				ServletActionContext.getRequest().getSession()
						.setAttribute("username",customer_name );
			}
			return SUCCESS;
		}
		return "error";
		
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