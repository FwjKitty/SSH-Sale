package com.hand.service;

import java.util.List;

import com.hand.model.PriceList;

public interface PriceListService {

	List<PriceList> getPriceListByPage(int pageSize,int pageRow);
	List<PriceList> getPriceListConfigs();
	int getCount();
}