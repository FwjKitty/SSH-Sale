package com.hand.dao;

import java.util.List;

import com.hand.model.NormalDiscount;
import com.hand.model.Role;
import com.hand.model.User;

public interface UserDao {
	public abstract int getCount();
	public abstract List<User> queryByPage(int pageSize, int pageNow);
	public abstract void save(User user);
	public abstract List<Role> getRole();
	public abstract User getUser(String username);
}
