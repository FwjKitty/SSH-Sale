/*package com.hand.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.dao.AddressDao;
import com.hand.dao.impl.AddressDaoImpl;
import com.hand.model.Address;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class AddressAction extends ActionSupport implements
		ModelDriven<Address> {

	@Resource
	private AddressDao addressDao;
	private List<Address> list;
	private Address address;

	
	public void showAddress() throws IOException {

		JsonObject lan = null;
		JsonArray jArray = new JsonArray();

		list = addressDao.getAddress();

		for (int i = 0; i < list.size(); i++) {
			lan = new JsonObject();
			lan.addProperty("addressid", list.get(i).getAddressId());
			lan.addProperty("address", list.get(i).getAddress());
			jArray.add(lan);
		}

		HttpServletResponse response = ServletActionContext.getResponse();
		String address = jArray.toString();
		System.out.println(address);
		response.getWriter().write(address);

	}

	
	public Address getModel() {
		// TODO Auto-generated method stub
		return address;
	}
}*/
