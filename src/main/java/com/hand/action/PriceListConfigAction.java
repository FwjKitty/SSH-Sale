package com.hand.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.cfg.Configuration;
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
	private List<PriceListConfig> priceListConfigs;
	
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
	
	public void showSelectCustomerCode(){
		JsonObject jsonObject = null;
		JsonArray jsonArray = new JsonArray();
		List<CustomersInfo> customerCodes = priceListConfigService.getCustomerCodes();
		for(CustomersInfo customersInfo : customerCodes){
			jsonObject = new JsonObject();
			jsonObject.addProperty("customerId", customersInfo.getCustomerId().toString());
			jsonObject.addProperty("customerCode", customersInfo.getCustomerCode());
			jsonArray.add(jsonObject);
		}
		try {
			ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showPriceListColumn(){
		JsonObject jsonObject = getPriceListColumn();
		try {
			System.out.println(jsonObject.toString());
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
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
	public JsonObject getPriceListColumn() {
		JsonObject priceListColumn = new JsonObject();
		priceListColumn.addProperty("hy_item","hy_item");
		priceListColumn.addProperty("effective_date_from","effective_date_from");
		priceListColumn.addProperty("effective_date_to","effective_date_to");
		priceListColumn.addProperty("user_def1","user_def1");
		priceListColumn.addProperty("user_def2","user_def2");
		priceListColumn.addProperty("user_def3","user_def3");
		priceListColumn.addProperty("user_def4","user_def4");
		priceListColumn.addProperty("user_def5","user_def5");
		priceListColumn.addProperty("user_def6","user_def6");
		priceListColumn.addProperty("user_def7","user_def7");
		priceListColumn.addProperty("user_def8","user_def8");
		priceListColumn.addProperty("user_def9","user_def9");
		priceListColumn.addProperty("user_def10","user_def10");
		priceListColumn.addProperty("user_def11","user_def11");
		priceListColumn.addProperty("user_def12","user_def12");
		priceListColumn.addProperty("user_def13","user_def13");
		priceListColumn.addProperty("user_def14","user_def14");
		priceListColumn.addProperty("user_def15","user_def15");
		priceListColumn.addProperty("user_def16","user_def16");
		priceListColumn.addProperty("user_def17","user_def17");
		priceListColumn.addProperty("user_def18","user_def18");
		priceListColumn.addProperty("user_def19","user_def19");
		priceListColumn.addProperty("user_def20","user_def20");
		priceListColumn.addProperty("user_def21","user_def21");
		priceListColumn.addProperty("user_def22","user_def22");
		priceListColumn.addProperty("user_def23","user_def23");
		priceListColumn.addProperty("user_def24","user_def24");
		priceListColumn.addProperty("user_def25","user_def25");
		priceListColumn.addProperty("user_def26","user_def26");
		priceListColumn.addProperty("user_def27","user_def27");
		priceListColumn.addProperty("user_def28","user_def28");
		priceListColumn.addProperty("user_def29","user_def29");
		priceListColumn.addProperty("user_def30","user_def30");
		return priceListColumn;
	}
	public List<PriceListConfig> getPriceListConfigs() {
		return priceListConfigs;
	}
	public void setPriceListConfigs(List<PriceListConfig> priceListConfigs) {
		this.priceListConfigs = priceListConfigs;
	}
}