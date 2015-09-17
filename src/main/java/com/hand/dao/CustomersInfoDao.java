package com.hand.dao;

import java.util.List;

import com.hand.model.CustomersInfo;

public interface CustomersInfoDao {

	List<Integer> queryIdByCodeAndTypeAndName(CustomersInfo customersInfo);
	List<CustomersInfo> queryCustomerCodes();
}