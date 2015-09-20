package com.hand.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.dao.SpecialDiscountDao;
import com.hand.model.CustomersInfo;
import com.hand.model.SpecialDiscount;
import com.hand.service.SpecialDiscountService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SpecialDiscountAction extends ActionSupport implements
		ModelDriven<SpecialDiscount> {

	@Resource
	private SpecialDiscountService specialDiscountService;
	@Resource
	private SpecialDiscountDao specialDiscountDao;
	private SpecialDiscount specialDiscount;
	private List<SpecialDiscount> specialDiscounts;
	// 获取编辑的normalId
	private int normalId;
	
	private int cutomerid;

	
	
	public SpecialDiscount getSpecialDiscount() {
		return specialDiscount;
	}

	public void setSpecialDiscount(SpecialDiscount specialDiscount) {
		this.specialDiscount = specialDiscount;
	}

	private int PAGESIZE = 10;

	// 查询属性
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;

	private int curPage = 1;

	public int getCurPage() {
		return curPage;
	}

	public int getNormalId() {
		return normalId;
	}

	public void setNormalId(int normalId) {
		this.normalId = normalId;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void show() {
		JsonObject lan = null;
		JsonArray jArray = new JsonArray();

		try {
			System.out.println("show");
			specialDiscounts = specialDiscountService.getSpecialDiscounts();

			for (int i = 0; i < specialDiscounts.size(); i++) {

				lan = new JsonObject();
				lan.addProperty("id", i + 1);
				lan.addProperty("discountId", specialDiscounts.get(i)
						.getDiscountId());
				// 得到用户ID
				// lan.addProperty("customerId", specialDiscounts.get(i)
				// .getc);
				lan.addProperty("discountName", specialDiscounts.get(i)
						.getDiscountName());
				lan.addProperty("customerCode", specialDiscounts.get(i)
						.getCustomerCode());
				lan.addProperty("amount", specialDiscounts.get(i).getAmount());
				lan.addProperty("appliedAmount", specialDiscounts.get(i)
						.getAppliedAmount());
				lan.addProperty("balance", specialDiscounts.get(i).getBalance());
				lan.addProperty("activity", specialDiscounts.get(i)
						.getActivity());
				jArray.add(lan);
			}

			HttpServletResponse response = ServletActionContext.getResponse();
			String address = jArray.toString();
			System.out.println(address);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCount() {
		int count;
		try {
			System.out.println("goback");
			count = specialDiscountService.getCount();
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
			System.out.println("showPage");
			specialDiscounts = specialDiscountService
					.getSpecialDiscountsByPage(PAGESIZE, curPage);
			System.out.println("action+" + curPage);
			for (int i = 0; i < specialDiscounts.size(); i++) {

				lan = new JsonObject();
				if (curPage == 1) {
					lan.addProperty("id", i);
				} else {
					lan.addProperty("id", (curPage - 1) * PAGESIZE++);
				}
				lan.addProperty("discountId", specialDiscounts.get(i)
						.getDiscountId());
				// 得到用户ID
				// lan.addProperty("customerId", specialDiscounts.get(i)
	
				
				
				
				// .getc);
				lan.addProperty("discountName", specialDiscounts.get(i)
						.getDiscountName());
				lan.addProperty("customerCode", specialDiscounts.get(i)
						.getCustomerCode());
				lan.addProperty("amount", specialDiscounts.get(i).getAmount());
				lan.addProperty("appliedAmount", specialDiscounts.get(i)
						.getAppliedAmount());
				lan.addProperty("balance", specialDiscounts.get(i).getBalance());
				lan.addProperty("activity", specialDiscounts.get(i)
						.getActivity());
				jArray.add(lan);
			}

			HttpServletResponse response = ServletActionContext.getResponse();
			String address = jArray.toString();
			System.out.println(address);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(address);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	public String add() {
		try {
			System.out.println("进入add");
			System.out.println("iiiiidddd"+specialDiscount.getDiscountId());
			CustomersInfo customersInfo =new CustomersInfo();
			int cuID=specialDiscountDao.queryCustomerId(specialDiscount.getCustomerCode());
			customersInfo.setCustomerId(cuID);
			specialDiscount.setCustomersInfo(customersInfo);
			System.out.println("activity+"+specialDiscount.getActivity() + "name"
					+ specialDiscount.getDiscountName() + "cusCode"
					+ specialDiscount.getCustomerCode()+"aoumet"+specialDiscount.getAmount()+"appliedAmout"+specialDiscount.getAppliedAmount()+"balance"+specialDiscount.getBalance());
			if (specialDiscount.getDiscountId() == null) {
				specialDiscountService.add(specialDiscount);
			} else {
				specialDiscountService.update(specialDiscount,
						specialDiscount.getDiscountId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String update() {
		System.out.println("进入编辑");
		// System.out.println("customerid" + customer.getCustomerId() + "first"
		// + customer.getFirstName() + "last" + customer.getLastName()
		// + "email" + customer.getEmail());
		specialDiscountService.update(specialDiscount, normalId);
		return "success";
	}

	public void query() {
		System.out.println("query");

		JsonObject lan = null;
		JsonArray jArray = new JsonArray();
		try {
			// 编码设置
			String name = ServletActionContext.getRequest()
					.getParameter("name");
			name = new String(name.getBytes("iso8859-1"), "UTF-8");
			String type = ServletActionContext.getRequest()
					.getParameter("type");
			type = new String(type.getBytes("iso8859-1"), "UTF-8");

			specialDiscounts = specialDiscountService.getSpecialDiscount(name,
					type,"kaidi");
			
			for (int i = 0; i < specialDiscounts.size(); i++) {
				lan = new JsonObject();
				lan.addProperty("id", i + 1);
				lan.addProperty("discountId", specialDiscounts.get(i)
						.getDiscountId());
				lan.addProperty("discountName", specialDiscounts.get(i)
						.getDiscountName());
				lan.addProperty("customerCode", specialDiscounts.get(i)
						.getCustomerCode());
				lan.addProperty("amount", specialDiscounts.get(i).getAmount());
				lan.addProperty("appliedAmount", specialDiscounts.get(i)
						.getAppliedAmount());
				lan.addProperty("balance", specialDiscounts.get(i).getBalance());
				lan.addProperty("activity", specialDiscounts.get(i)
						.getActivity());
				jArray.add(lan);
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			String address = jArray.toString();
			System.out.println(address);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(address);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public SpecialDiscount getModel() {
		// TODO Auto-generated method stub
		return specialDiscount;
	}

	public int getCutomerid() {
		return cutomerid;
	}

	public void setCutomerid(int cutomerid) {
		this.cutomerid = cutomerid;
	}

}
