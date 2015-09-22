package com.hand.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckLoginInterceptor implements Interceptor {

	public void destroy() {}
	public void init() {}

	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String pathTo = request.getServletPath();
		if (pathTo.equals("/LoginAction.action")) {
			System.out.println("过去拦截器");
			return invocation.invoke();
		}
		HttpSession session = null;
		session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			return invocation.invoke();
		} else {
			return "unLogin";
		}
	}
}