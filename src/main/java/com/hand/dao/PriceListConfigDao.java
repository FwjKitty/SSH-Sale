package com.hand.dao;

import java.util.List;

import com.hand.model.PriceListConfig;

public interface PriceListConfigDao {

	List<PriceListConfig> queryByPage(int pageSize, int pageNow);
	List<PriceListConfig> queryAll();
	int getCount();
	List<PriceListConfig> queryByActivity(String activity);
	List<PriceListConfig> queryByExcelCol(int excelCol);
	List<PriceListConfig> queryByDisplayName(String displayName);
	List<PriceListConfig> queryByActivityAndExcelColAndDisplayName(PriceListConfig priceListConfig);
	List<PriceListConfig> queryByCustomerIdAndActivityAndExcelColAndDisplayName(
			List<Integer> customerIds,PriceListConfig priceListConfig);
	List<PriceListConfig> queryByCustomerId(List<Integer> customerIds);
	List<PriceListConfig> queryByCustomerIdAndActivity(List<Integer> customerIds);
	List<PriceListConfig> queryByCustomerIdAndActivity(int customerId);
	int update(List<PriceListConfig> priceListConfigs);
	int save(List<PriceListConfig> priceListConfigs);
}