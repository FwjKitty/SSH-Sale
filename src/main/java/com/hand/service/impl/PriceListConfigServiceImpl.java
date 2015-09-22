package com.hand.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hand.dao.CustomersInfoDao;
import com.hand.dao.PriceListConfigDao;
import com.hand.dao.impl.CustomersInfoDaoImpl;
import com.hand.dao.impl.PriceListConfigDaoImpl;
import com.hand.model.CustomersInfo;
import com.hand.model.PriceListConfig;
import com.hand.service.PriceListConfigService;

@Service
public class PriceListConfigServiceImpl implements PriceListConfigService {

	@Resource
	private PriceListConfigDao priceListConfigDao = new PriceListConfigDaoImpl();
	@Resource
	private CustomersInfoDao customersInfoDao = new CustomersInfoDaoImpl();
	public List<PriceListConfig> getPriceListConfigsByPage(int pageSize, int pageRow) {
		return priceListConfigDao.queryByPage(pageSize, pageRow);
	}
	public List<PriceListConfig> getPriceListConfigs() {
		return priceListConfigDao.queryAll();
	}
	public int getCount() {
		return priceListConfigDao.getCount();
	}
	public List<PriceListConfig> searchPriceListConfig(CustomersInfo customersInfo, PriceListConfig priceListConfig) {
		List<Integer> customerIds = customersInfoDao.queryIdByCodeAndTypeAndName(customersInfo);
		if(customerIds.size() > 0){
			if(priceListConfig == null){
				return priceListConfigDao.queryByCustomerId(customerIds);
			}
			return priceListConfigDao.queryByCustomerIdAndActivityAndExcelColAndDisplayName(customerIds, priceListConfig);
		}else{
			return priceListConfigDao.queryByActivityAndExcelColAndDisplayName(priceListConfig);
		}
	}
	public int updateList(List<PriceListConfig> priceListConfigs) {
		return priceListConfigDao.update(priceListConfigs);
	}
	public int saveList(List<PriceListConfig> priceListConfigs) {
		return priceListConfigDao.save(priceListConfigs);
	}
	public List<CustomersInfo> getCustomerCodes() {
		return customersInfoDao.queryCustomerCodes();
	}
}