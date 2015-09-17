package com.hand.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.model.CustomersInfo;
import com.hand.model.PriceListConfig;
import com.hand.service.PriceListConfigService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class PriceListConfigAction extends ActionSupport {

	@Resource
	private PriceListConfigService priceListConfigService;
	private int pageSize = 10;
	private int pageNow;
	private int count;
	private CustomersInfo customersInfo;
	private PriceListConfig priceListConfig;
	
	public String show(){
		//List<PriceListConfig> priceListConfigs = priceListConfigService.getPriceListConfigsByPage(pageSize,1);
		//ServletActionContext.getRequest().setAttribute("priceListConfigs", priceListConfigs);
		this.setCount(priceListConfigService.getCount());
		this.setPageNow(1);
		return "success";
	}
	public void getPageResult(){
		List<PriceListConfig> priceListConfigs = priceListConfigService.getPriceListConfigsByPage(pageSize,pageNow);
		JsonArray jsonArray = new JsonArray();
		JsonObject jsonObject = null;
		try {
			for (int i = 0; i < priceListConfigs.size(); i++) {
				jsonObject = new JsonObject();
//				jsonObject.addProperty("number", i+1);
				jsonObject.addProperty("priceListCol", priceListConfigs.get(i).getPriceListCol());
				jsonObject.addProperty("displayName", priceListConfigs.get(i).getDisplayName());
				jsonObject.addProperty("excelCol", priceListConfigs.get(i).getExcelCol().toString());
				jsonObject.addProperty("activity", priceListConfigs.get(i).getActivity());
				jsonObject.addProperty("customerId", priceListConfigs.get(i).getCustomersInfo().getCustomerId().toString());
				jsonObject.addProperty("priceListConfigId", priceListConfigs.get(i).getPriceListConfigId());
				jsonArray.add(jsonObject);
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			this.setCount(priceListConfigService.getCount());
			this.setPageNow(pageNow);
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void search(){
		List<PriceListConfig> priceListConfigs = priceListConfigService.searchPriceListConfig(customersInfo,priceListConfig,pageSize,pageNow);
		JsonArray jsonArray = new JsonArray();
		JsonObject jsonObject = null;
		try {
			for (int i = 0; i < priceListConfigs.size(); i++) {
				jsonObject = new JsonObject();
//				jsonObject.addProperty("number", i+1);
				jsonObject.addProperty("priceListCol", priceListConfigs.get(i).getPriceListCol());
				jsonObject.addProperty("displayName", priceListConfigs.get(i).getDisplayName());
				jsonObject.addProperty("excelCol", priceListConfigs.get(i).getExcelCol().toString());
				jsonObject.addProperty("activity", priceListConfigs.get(i).getActivity());
				jsonObject.addProperty("customerId", priceListConfigs.get(i).getCustomersInfo().getCustomerId().toString());
				jsonObject.addProperty("priceListConfigId", priceListConfigs.get(i).getPriceListConfigId());
				jsonArray.add(jsonObject);
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			this.setCount(priceListConfigService.getCount());
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void validateSearch() {
		if ((customersInfo.getCustomerCode() == null || customersInfo.getCustomerCode().trim().equals(""))
    		  &&(customersInfo.getType() == null || customersInfo.getType().trim().equals(""))
    		  &&(customersInfo.getCustomerName() == null || customersInfo.getCustomerName().trim().equals(""))
    		  &&(priceListConfig.getActivity() == null || priceListConfig.getActivity().trim().equals(""))
    		  &&(priceListConfig.getExcelCol() == null || priceListConfig.getExcelCol().toString().trim().equals(""))
    		  &&(priceListConfig.getDisplayName() == null || priceListConfig.getDisplayName().trim().equals(""))){
    	  addFieldError("msg","请输入查询内容");
      	}
	}
	
	public String save(){
		priceListConfigService.save(priceListConfig);
		priceListConfig.setCustomersInfo(customersInfo);
		return "success";
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public CustomersInfo getCustomersInfo() {
		return customersInfo;
	}
	public void setCustomersInfo(CustomersInfo customersInfo) {
		this.customersInfo = customersInfo;
	}
	public PriceListConfig getPriceListConfig() {
		return priceListConfig;
	}
	public void setPriceListConfig(PriceListConfig priceListConfig) {
		this.priceListConfig = priceListConfig;
	}
}