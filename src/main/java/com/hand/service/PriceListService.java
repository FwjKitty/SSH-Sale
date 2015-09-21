package com.hand.service;

import java.util.List;

import com.google.gson.JsonArray;
import com.hand.model.CustomersInfo;
import com.hand.model.PriceList;
import com.hand.model.PriceListConfig;

public interface PriceListService {

	List<PriceList> getPriceListByPage(int pageSize,int pageRow);
	List<PriceList> getPriceListConfigs();
	int getCount();
	List<PriceListConfig> getHeader(int customerId);
	List<PriceListConfig> getHeader(CustomersInfo customersInfo);
	JsonArray searchPriceList(CustomersInfo customersInfo,PriceList priceList);
	List<CustomersInfo> getCustomerCodes();
	int saveList(List<PriceList> priceLists);
}