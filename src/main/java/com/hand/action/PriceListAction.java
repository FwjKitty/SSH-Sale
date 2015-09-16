package com.hand.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.model.PriceList;
import com.hand.model.PriceListConfig;
import com.hand.service.PriceListConfigService;
import com.hand.service.PriceListService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class PriceListAction extends ActionSupport {

	@Resource
	private PriceListService priceListService;
	private int pageSize = 10;
	private int pageNow;
	private int count;
	
	public String show(){
		//List<PriceList> priceList = priceListService.getPriceListByPage(pageSize,1);
		//ServletActionContext.getRequest().setAttribute("priceListConfigs", priceList);
		this.setCount(priceListService.getCount());
		this.setPageNow(1);
		return "success";
	}
	public void getPageResult(){
		List<PriceList> priceList = priceListService.getPriceListByPage(pageSize,pageNow);
		JsonArray jsonArray = new JsonArray();
		JsonObject jsonObject = null;
		try {
			for (int i = 0; i < priceList.size(); i++) {
				jsonObject = new JsonObject();
//				jsonObject.addProperty("number", i+1);
				jsonObject.addProperty("priceListId", priceList.get(i).getPriceListId());
				jsonObject.addProperty("hyItem", priceList.get(i).getHyItem());
				jsonObject.addProperty("effectiveDateFrom", priceList.get(i).getEffectiveDateFrom().toString());
				jsonObject.addProperty("effectiveDateTo", priceList.get(i).getEffectiveDateTo().toString());
				jsonArray.add(jsonObject);
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			this.setCount(priceListService.getCount());
			this.setPageNow(pageNow);
			System.out.println(jsonArray.toString());
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
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
}