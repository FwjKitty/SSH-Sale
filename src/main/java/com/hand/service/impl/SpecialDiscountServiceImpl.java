package com.hand.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.NormalDiscountDao;
import com.hand.dao.SpecialDiscountDao;
import com.hand.model.CustomersInfo;
import com.hand.model.NormalDiscount;
import com.hand.model.SpecialDiscount;
import com.hand.service.SpecialDiscountService;

@Service
@Transactional
public class SpecialDiscountServiceImpl implements SpecialDiscountService {

	@Resource
	private SpecialDiscountDao specialDiscountDao;

	public List<SpecialDiscount> getSpecialDiscountsByPage(int pageSize,
			int pageNow) {
		return specialDiscountDao.queryByPage(pageSize, pageNow);

	}

	public List<SpecialDiscount> getSpecialDiscounts() {

		return specialDiscountDao.getSpecialDiscounts();
	}

	public int getCount() {
		int count = specialDiscountDao.getCount();
		return count;
	}

	public void update(SpecialDiscount specialDiscount, int normalId) {
		specialDiscountDao.update(specialDiscount, normalId);

	}

	public void add(SpecialDiscount specialDiscount) {
		specialDiscountDao.save(specialDiscount);
	}

	public List<SpecialDiscount> getSpecialDiscount(String name, String type) {
		return specialDiscountDao.getSpecialDiscount(name, type);
	}

	

}
