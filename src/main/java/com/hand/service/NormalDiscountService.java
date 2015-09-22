package com.hand.service;

import java.util.List;

import com.hand.model.NormalDiscount;
public interface NormalDiscountService {
	
	public abstract int getCount();
	public abstract List<NormalDiscount> getNormalDiscounts();
	public abstract List<NormalDiscount> getNormalDiscountsByPage(int pageSize, int pageNow);
	public abstract void update(NormalDiscount normalDiscount, int normalId);
	public abstract void add(NormalDiscount normalDiscount);
	public abstract List<NormalDiscount> getNormalDiscount(String name,String type);
}
