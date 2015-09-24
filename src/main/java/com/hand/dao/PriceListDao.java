package com.hand.dao;

import java.util.List;

import com.google.gson.JsonArray;
import com.hand.model.PriceList;
import com.hand.model.PriceListConfig;

public interface PriceListDao {

	List<PriceList> queryByPage(int pageSize, int pageNow);
	List<PriceList> queryAll();
	int getCount();
	JsonArray queryByCustomerIdAndHyItemAndActivity(List<Integer> customerIds,
			PriceList priceList,List<PriceListConfig> priceListConfigs);
	JsonArray queryByCustomerIdAndActivity(List<Integer> customerIds,
			List<PriceListConfig> priceListConfigs);
	int update(List<PriceList> priceLists);
	int save(List<PriceList> priceLists);
	List<Object[]> queryByPriceListColAndPriceListId(String priceListCol,List<Integer> priceListIds);
}