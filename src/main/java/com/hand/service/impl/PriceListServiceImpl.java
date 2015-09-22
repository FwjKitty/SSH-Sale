package com.hand.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.hand.dao.CustomersInfoDao;
import com.hand.dao.PriceListConfigDao;
import com.hand.dao.PriceListDao;
import com.hand.dao.impl.CustomersInfoDaoImpl;
import com.hand.dao.impl.PriceListConfigDaoImpl;
import com.hand.dao.impl.PriceListDaoImpl;
import com.hand.model.CustomersInfo;
import com.hand.model.PriceList;
import com.hand.model.PriceListConfig;
import com.hand.service.PriceListService;

@Service
public class PriceListServiceImpl implements PriceListService {

	@Resource
	private PriceListDao priceListDao = new PriceListDaoImpl();
	@Resource
	private CustomersInfoDao customersInfoDao = new CustomersInfoDaoImpl();
	@Resource
	private PriceListConfigDao priceListConfigDao = new PriceListConfigDaoImpl();
	public List<PriceList> getPriceListByPage(int pageSize, int pageRow) {
		return priceListDao.queryByPage(pageSize, pageRow);
	}
	public List<PriceList> getPriceListConfigs() {
		return priceListDao.queryAll();
	}
	public int getCount() {
		return priceListDao.getCount();
	}
	public List<PriceListConfig> getHeader(int customerId) {
		return priceListConfigDao.queryByCustomerIdAndActivity(customerId);
	}
	public List<PriceListConfig> getHeader(CustomersInfo customersInfo) {
		List<Integer> customerIds = customersInfoDao.queryIdByCodeAndTypeAndName(customersInfo);
		return priceListConfigDao.queryByCustomerIdAndActivity(customerIds.get(0));
	}
	public JsonArray searchPriceList(CustomersInfo customersInfo, PriceList priceList) {
		List<Integer> customerIds = customersInfoDao.queryIdByCodeAndTypeAndName(customersInfo);
		List<PriceListConfig> priceListConfigs = priceListConfigDao.queryByCustomerIdAndActivity(customerIds);
		if(priceList != null){
			return priceListDao.queryByCustomerIdAndHyItemAndActivity(customerIds,priceList,priceListConfigs);
		}else{
			return priceListDao.queryByCustomerIdAndActivity(customerIds,priceListConfigs);
		}
	}
	public List<CustomersInfo> getCustomerCodes() {
		return customersInfoDao.queryCustomerCodes();
	}
	public int updateList(List<PriceList> priceLists) {
		return priceListDao.update(priceLists);
	}
	public int saveList(List<PriceList> priceLists) {
		return priceListDao.save(priceLists);
	}
}