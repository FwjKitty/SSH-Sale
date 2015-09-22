package com.hand.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.NormalDiscountDao;
import com.hand.model.NormalDiscount;
import com.hand.service.NormalDiscountService;
import javax.annotation.Resource;

@Service
@Transactional
public class NormalDiscountServiceImpl implements NormalDiscountService {

	@Resource
	private NormalDiscountDao NormalDiscountDao;
	


	
	public List<NormalDiscount> getNormalDiscountsByPage(int pageSize,
			int pageNow) {
			return NormalDiscountDao.queryByPage(pageSize, pageNow);

		}
	
	public List<NormalDiscount> getNormalDiscounts() {

		return NormalDiscountDao.getNormalDiscounts();
	}

	
	public int getCount() {
		int count=NormalDiscountDao.getCount();
		return count;
	}

	public void update(NormalDiscount normalDiscount, int normalId) {
		NormalDiscountDao.update(normalDiscount, normalId);
		
	}

	public void add(NormalDiscount normalDiscount) {
		NormalDiscountDao.save(normalDiscount);
	}
	public   List<NormalDiscount> getNormalDiscount(String name,String type){
		return NormalDiscountDao.getNormalDiscount(name, type);
	}

}
