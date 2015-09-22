package com.hand.service;

import java.util.List;

import com.hand.model.NormalDiscount;
import com.hand.model.User;

public interface UserService {
	public abstract int getCount();
	public abstract List<User> getNormalDiscountsByPage(int pageSize, int pageNow);
	public abstract void add(User user);

}
