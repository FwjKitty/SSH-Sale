package com.hand.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.IEclipseSourceContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.dao.DiscountRecordDao;
import com.hand.model.DiscountAppliedRecords;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DiscountRecordAction extends ActionSupport implements
ModelDriven<DiscountAppliedRecords> {
	
	@Resource
	private DiscountRecordDao discountRecordDao;
	private DiscountAppliedRecords discountAppliedRecords;
	private List<DiscountAppliedRecords> list;
	private int discountId;
	
	// 获取CutsomerInfo对象
		public void showRecords() {

			JsonObject lan = null;
			JsonArray jArray = new JsonArray();
			System.out.println("showRecord");
			try {
				System.out.println("show Record");
				list = discountRecordDao.getDiscounts(discountId);
				System.out.println("chenggong");
				for (int i = 0; i < list.size(); i++) {
					lan = new JsonObject();
					lan.addProperty("id", i);
					lan.addProperty("discountName", list.get(i).getDiscountName());
					lan.addProperty("customerCode", list.get(i).getCustomerCode());
					lan.addProperty("identifyNum", list.get(i).getAdnIdentifyNum());
					lan.addProperty("applyAmount", list.get(i).getAppliedAmount());
					lan.addProperty("applyDate", list.get(i).getAppliedDate().toString());
					if(list.get(i).getCancel()!=null){
					lan.addProperty("cancel", list.get(i).getCancel());
					}else {
						lan.addProperty("cancel", "");
					}
					if(list.get(i).getCancelDate()!=null){
					lan.addProperty("canelDate", list.get(i).getCancelDate()
							.toString());
					}else {
						lan.addProperty("canelDate","");
					}
					jArray.add(lan);
				}
				
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				String address = jArray.toString();
				System.out.println(address);
				response.getWriter().write(address);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public DiscountAppliedRecords getModel() {
			// TODO Auto-generated method stub
			return discountAppliedRecords;
		}

		public int getDiscountId() {
			return discountId;
		}

		public void setDiscountId(int discountId) {
			this.discountId = discountId;
		}

	
	
	

}
