package com.hand.action;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

import com.hand.model.CustomersInfo;

import com.hand.service.CustomerService;

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
	private CustomerService customerService;
	
	private List<CustomersInfo> customers;
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


	public List<CustomersInfo> getCustomers() {
		return customers;
	}
	public void setCustomers(List<CustomersInfo> customers) {
		this.customers = customers;
	}
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
	/*	List customerIds= new ArrayList();
		customerIds=customerService.queryIdByCodeAndTypeAndName(customerCode,type,customerName);*/
		System.out.println("进入customerlistAction");
		System.out.println(customerCode);
		setCustomers(customerService.findAllcustomers(customerCode,type,customerName,status,groupCompany,corporation));
		return SUCCESS;
	}

	
	
	
	
	/*public void show() {
		JsonObject lan = null;
		JsonArray jArray = new JsonArray();

		try {
			customers = customerService.getCustomers();

			for (int i = 0; i < customers.size(); i++) {
				lan = new JsonObject();
				lan.addProperty("first_name", customers.get(i).getFirstName());
				lan.addProperty("last_name", customers.get(i).getLastName());
				lan.addProperty("email", customers.get(i).getEmail());
				lan.addProperty("customer_id", customers.get(i).getCustomerId());
				lan.addProperty("address_id", customers.get(i).getAddress()
						.getAddress().toString());
				lan.addProperty("last_update", customers.get(i).getLastUpdate()
						.toString());
				jArray.add(lan);
			}

			HttpServletResponse response = ServletActionContext.getResponse();
			String address = jArray.toString();
			System.out.println(address);
			response.getWriter().write(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCount(){
		int count;
		try {
			System.out.println("goback");
			count = customerService.getCount();
			System.out.println(count);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.getWriter().write(String.valueOf(count));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	
	public void showPage() {
		JsonObject lan = null;
		JsonArray jArray = new JsonArray();

		try {
			customers = customerService.getCustomersByPage(PAGESIZE, curPage);
			System.out.println("action+" + curPage);

			for (int i = 0; i < customers.size(); i++) {
				lan = new JsonObject();
				lan.addProperty("first_name", customers.get(i).getFirstName());
				lan.addProperty("last_name", customers.get(i).getLastName());
				lan.addProperty("email", customers.get(i).getEmail());
				lan.addProperty("customer_id", customers.get(i).getCustomerId());
				lan.addProperty("address_id", customers.get(i).getAddress()
						.getAddress().toString());
				lan.addProperty("last_update", customers.get(i).getLastUpdate()
						.toString());
				jArray.add(lan);
			}

			HttpServletResponse response = ServletActionContext.getResponse();
			String address = jArray.toString();
			System.out.println(address);
			response.getWriter().write(address);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
*/




}
