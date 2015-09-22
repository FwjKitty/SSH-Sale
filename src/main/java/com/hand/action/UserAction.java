package com.hand.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.dao.UserDao;
import com.hand.model.NormalDiscount;
import com.hand.model.Role;
import com.hand.model.User;
import com.hand.service.NormalDiscountService;
import com.hand.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	@Resource
	private UserService userService;
	private User user;
	private List<User> users;
	@Resource
	private UserDao userDao;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	List<Role> roles;

	private int rolesName;

	public int getRolesName() {
		return rolesName;
	}

	public void setRolesName(int rolesName) {
		this.rolesName = rolesName;
	}

	private int PAGESIZE = 10;
	private int curPage = 1;

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void getCount() {
		int count;
		try {
			count = userService.getCount();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.getWriter().write(String.valueOf(count));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showPage() {
		JsonObject lan = null;
		JsonArray jArray = new JsonArray();
		Role role = new Role();
		try {
			users = userService.getNormalDiscountsByPage(PAGESIZE, curPage);
			for (int i = 0; i < users.size(); i++) {

				lan = new JsonObject();
				if (curPage == 1) {
					lan.addProperty("id", i);
				} else {
					lan.addProperty("id", (curPage - 1) * PAGESIZE++);
				}
				lan.addProperty("userId", users.get(i).getUserId());
				lan.addProperty("username", users.get(i).getUsername());
				role = users.get(i).getRole();
				lan.addProperty("roleName", role.getRoleName());
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
			Role role = new Role();
			role.setRoleId(rolesName);
			user.setRole(role);
		
			userService.add(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void showRole() {

		JsonObject lan = null;
		JsonArray jArray = new JsonArray();
		try {	
			roles = userDao.getRole();
			for (int i = 0; i < roles.size(); i++) {
				lan = new JsonObject();
				lan.addProperty("roleId", roles.get(i).getRoleId());
				lan.addProperty("rolename", roles.get(i).getRoleName());
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

	public void ShowOne(){
		JsonObject lan = null;
		JsonArray jArray = new JsonArray();
		Role role = new Role();
		try {
			String username=ServletActionContext.getRequest().getSession().getAttribute("username").toString();
			user = userDao.getUser(username);
			if(user!=null){
				lan = new JsonObject();
				lan.addProperty("userId", user.getUserId().toString());
				lan.addProperty("username", user.getUsername());
				role = user.getRole();
				lan.addProperty("roleName", role.getRoleName());
				
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			String ss=lan.toString();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(ss);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getModel() {
		return user;
	}

}
