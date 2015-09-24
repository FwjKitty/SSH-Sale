package com.hand.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.dao.ShowCustomerCodeDao;
import com.hand.dao.SpecialDiscountDao;
import com.hand.model.CustomersInfo;
import com.hand.model.SpecialDiscount;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class ShowCustomerCodeAction extends ActionSupport implements
		ModelDriven<CustomersInfo> {
	@Resource
	private ShowCustomerCodeDao showCustomerCodeDao;
	private CustomersInfo customersInfo;
	private List<CustomersInfo> list;

	// 获取CutsomerInfo对象
	public void showCustomers() {

		JsonObject lan = null;
		JsonArray jArray = new JsonArray();
		System.out.println("showCus");
		try {
			
			list = showCustomerCodeDao.getCustomersInfo();
			customersInfo=new CustomersInfo();
			System.out.println("cutomerid+" + customersInfo.getCustomerId()
					+ "customerCode+" + customersInfo.getCustomerCode());
			System.out.println("chenggong");
			for (int i = 0; i < list.size(); i++) {
				lan = new JsonObject();
				lan.addProperty("customerId", list.get(i).getCustomerId());
				lan.addProperty("customerCode", list.get(i).getCustomerCode());
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

	public CustomersInfo getModel() {
		return customersInfo;
	}

}
