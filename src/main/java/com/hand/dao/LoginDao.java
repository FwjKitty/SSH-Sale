package com.hand.dao;

import com.hand.model.CustomersInfo;

public interface LoginDao {

	public abstract CustomersInfo getCustomer(String firstName);
}
