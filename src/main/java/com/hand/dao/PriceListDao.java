package com.hand.dao;

import java.util.List;

import com.hand.model.PriceList;

public interface PriceListDao {

	List<PriceList> queryByPage(int pageSize, int pageNow);
	List<PriceList> queryAll();
	int getCount();
}