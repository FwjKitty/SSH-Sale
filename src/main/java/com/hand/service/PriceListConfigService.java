package com.hand.service;

import java.util.List;

import com.hand.model.CustomersInfo;
import com.hand.model.PriceListConfig;

public interface PriceListConfigService {

	List<PriceListConfig> getPriceListConfigsByPage(int pageSize, int pageRow);
	List<PriceListConfig> getPriceListConfigs();
	int getCount();
	List<PriceListConfig> searchPriceListConfig(CustomersInfo customersInfo,PriceListConfig priceListConfig);
	int updateList(List<PriceListConfig> priceListConfigs);
	int saveList(List<PriceListConfig> priceListConfigs);
	List<CustomersInfo> getCustomerCodes();
}