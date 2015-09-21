package com.hand.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.tiles.request.Request;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.model.NormalDiscount;
import com.hand.service.NormalDiscountService;
import com.mysql.fabric.Response;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class NormalDiscountAction extends ActionSupport implements
		ModelDriven<NormalDiscount> {

	@Resource
	private NormalDiscountService normalDiscountService;

	private NormalDiscount normalDiscount;
	private List<NormalDiscount> mormalDiscounts;
	// 获取编辑的normalId
	private int normalId;
	private int PAGESIZE = 10;

	//查询属性
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
	public NormalDiscount getNormalDiscount() {
		return normalDiscount;
	}

	public void setNormalDiscount(NormalDiscount normalDiscount) {
		this.normalDiscount = normalDiscount;
	}

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
			mormalDiscounts = normalDiscountService.getNormalDiscounts();

			for (int i = 0; i < mormalDiscounts.size(); i++) {

				lan = new JsonObject();
				lan.addProperty("id", i + 1);
				lan.addProperty("normalId", mormalDiscounts.get(i)
						.getNormalId());
				lan.addProperty("discountName", mormalDiscounts.get(i)
						.getDiscountName());
				lan.addProperty("type", mormalDiscounts.get(i).getType());
				lan.addProperty("discountBase", mormalDiscounts.get(i)
						.getDiscountBase());
				lan.addProperty("baseQty", mormalDiscounts.get(i).getBaseQty());
				lan.addProperty("discountRate", mormalDiscounts.get(i)
						.getDiscountRate());
				lan.addProperty("activity", mormalDiscounts.get(i)
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
			count = normalDiscountService.getCount();
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
			mormalDiscounts = normalDiscountService.getNormalDiscountsByPage(
					PAGESIZE, curPage);
			for (int i = 0; i < mormalDiscounts.size(); i++) {

				lan = new JsonObject();
				if(curPage==1){
					lan.addProperty("id",i);
				}else{
					lan.addProperty("id", (curPage-1)*PAGESIZE++);
				}
				lan.addProperty("normalId", mormalDiscounts.get(i)
						.getNormalId());
				lan.addProperty("discountName", mormalDiscounts.get(i)
						.getDiscountName());
				lan.addProperty("type", mormalDiscounts.get(i).getType());
				lan.addProperty("discountBase", mormalDiscounts.get(i)
						.getDiscountBase());
				if (mormalDiscounts.get(i).getBaseQty() != null) {
					lan.addProperty("baseQty", mormalDiscounts.get(i)
							.getBaseQty());
				} else {
					lan.addProperty("baseQty", "");
				}
				lan.addProperty("discountRate", mormalDiscounts.get(i)
						.getDiscountRate());
				lan.addProperty("activity", mormalDiscounts.get(i)
						.getActivity());
				jArray.add(lan);
			}

			HttpServletResponse response = ServletActionContext.getResponse();
			String address = jArray.toString();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(address);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String add() {
		try {
			System.out.println("进入add");
			System.out.println(normalDiscount);

			System.out.println(normalDiscount.getActivity() + "type"
					+ normalDiscount.getType() + "ndid"
					+ normalDiscount.getNormalId());
			if (normalDiscount.getNormalId() == null) {
				normalDiscountService.add(normalDiscount);
			} else {
				normalDiscountService.update(normalDiscount,
						normalDiscount.getNormalId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String update() {
		System.out.println("进入编辑");
		normalDiscountService.update(normalDiscount, normalId);
		return "success";
	}

	public void query()  {
		System.out.println("query");
		
		
		JsonObject lan = null;
		JsonArray jArray = new JsonArray();
		try {
			//编码设置
			String name=ServletActionContext.getRequest().getParameter("name");
			name = new String(name.getBytes("iso8859-1"),"UTF-8");
			String type=ServletActionContext.getRequest().getParameter("type");
			type = new String(type.getBytes("iso8859-1"),"UTF-8");
			
			System.out.println("action+" + name+"type+"+type);
			mormalDiscounts = normalDiscountService.getNormalDiscount(name, type);
			for (int i = 0; i < mormalDiscounts.size(); i++) {

				lan = new JsonObject();
				lan.addProperty("id", i + 1);
				lan.addProperty("normalId", mormalDiscounts.get(i)
						.getNormalId());
				lan.addProperty("discountName", mormalDiscounts.get(i)
						.getDiscountName());
				lan.addProperty("type", mormalDiscounts.get(i).getType());
				lan.addProperty("discountBase", mormalDiscounts.get(i)
						.getDiscountBase());
				if (mormalDiscounts.get(i).getBaseQty() != null) {
					lan.addProperty("baseQty", mormalDiscounts.get(i)
							.getBaseQty());
				} else {
					lan.addProperty("baseQty", "");
				}
				lan.addProperty("discountRate", mormalDiscounts.get(i)
						.getDiscountRate());
				lan.addProperty("activity", mormalDiscounts.get(i)
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

	public NormalDiscount getModel() {
		// TODO Auto-generated method stub
		return normalDiscount;
	}

}
