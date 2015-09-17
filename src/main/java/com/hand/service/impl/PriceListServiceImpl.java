package com.hand.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hand.dao.PriceListDao;
import com.hand.dao.impl.PriceListDaoImpl;
import com.hand.model.PriceList;
import com.hand.service.PriceListService;

@Service
public class PriceListServiceImpl implements PriceListService {

	@Resource
	private PriceListDao priceListDao = new PriceListDaoImpl();
	public List<PriceList> getPriceListByPage(int pageSize, int pageRow) {
		return priceListDao.queryByPage(pageSize, pageRow);
	}
	public List<PriceList> getPriceListConfigs() {
		return priceListDao.queryAll();
	}
	public int getCount() {
		return priceListDao.getCount();
	}
}