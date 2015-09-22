package com.hand.dao;

import com.hand.model.CustomersInfo;
import com.hand.model.User;

public interface LoginDao {

	public abstract User getCustomer(String firstName,String password);
}
