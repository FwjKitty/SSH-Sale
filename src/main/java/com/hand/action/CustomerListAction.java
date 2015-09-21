package com.hand.action;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.model.CustomersInfo;

import com.hand.service.CustomersInfoService;
import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


@Controller
public class CustomerListAction extends ActionSupport implements
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
	/*private List customerIds;*/
	private int PAGESIZE = 10;
	private int curPage = 1;
	public CustomersInfo getCustomer() {
		return customer;
	}
	public void setCustomer(CustomersInfo customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public int getPAGESIZE() {
		return PAGESIZE;
	}
	public void setPAGESIZE(int pAGESIZE) {
		PAGESIZE = pAGESIZE;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public CustomersInfo getModel() {
		return customer;
	}
	public String execute() throws Exception{

		List<CustomersInfo> customerinfo=customerService.findAllcustomers(customerCode,type,customerName,status,groupCompany,corporation);
		JsonArray jsonArray=new JsonArray();
		JsonObject jo=null;
		
		for(int i=0;i<customerinfo.size();i++){
			System.out.println("s");
			jo = new JsonObject();
			jo.addProperty("CN",customerinfo.get(i).getCustomerName());
			jo.addProperty("CD", customerinfo.get(i).getCustomerCode());
			jo.addProperty("Coun", customerinfo.get(i).getAddress().getCountry());
			jo.addProperty("BM", customerinfo.get(i).getOrganization().getBusinessManager());
			jo.addProperty("BA", customerinfo.get(i).getOrganization().getBusinessAssistant());
			jo.addProperty("Sta", customerinfo.get(i).getAddress().getStatus());
			jo.addProperty("id",customerinfo.get(i).getCustomerId());
			jsonArray.add(jo);
		}
		try{
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				String address = jsonArray.toString();
				response.getWriter().write(address);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
}
