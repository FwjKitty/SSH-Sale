package com.hand.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.hand.model.CustomersInfo;
import com.hand.service.CustomersInfoService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class ConfirmAction extends ActionSupport implements
	ModelDriven<CustomersInfo> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Resource
		private CustomersInfoService customerService;
		private int customerId;
		private String jue;
		public String getJue() {
			return jue;
		}
		public void setJue(String jue) {
			this.jue = jue;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public CustomersInfo getModel() {
			
			// TODO Auto-generated method stub
			return null;
		}
		public String execute() throws Exception{
			System.out.println("进入确认action");
			//System.out.println("获取到国家="+country);
			System.out.println("获取到id="+customerId);
			customerService.comfirm(customerId);
			setJue("状态确认成功！");
			return "success";
		}
		
}
