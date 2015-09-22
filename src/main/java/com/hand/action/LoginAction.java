package com.hand.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.hand.dao.LoginDao;
import com.hand.model.Role;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	@Resource
	private LoginDao loginDao;
	private String username;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;
	public String execute(){
		
		if (loginDao.getCustomer(username,password) != null) {
			
				ServletActionContext.getRequest().getSession()
						.setAttribute("username",username);
			
				Role role =new Role();
				role=loginDao.getCustomer(username,password).getRole();
				String rolename=role.getRoleName();
				ServletActionContext.getRequest().getSession()
				.setAttribute("roleName",rolename);
			
			return SUCCESS;
		}
		return "error";
		
	}
	

	public String out(){
		return "out";
	}
	
}