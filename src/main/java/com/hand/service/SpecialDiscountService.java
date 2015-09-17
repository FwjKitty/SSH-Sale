package com.hand.service;

import java.util.List;

import com.hand.model.CustomersInfo;
import com.hand.model.NormalDiscount;
import com.hand.model.SpecialDiscount;

public interface SpecialDiscountService {
	public abstract int getCount();
	public abstract List<SpecialDiscount> getSpecialDiscounts();
	public abstract List<SpecialDiscount> getSpecialDiscountsByPage(int pageSize, int pageNow);
	public abstract void update(SpecialDiscount specialDiscount, int normalId);
	public abstract void add(SpecialDiscount specialDiscount);
	public abstract List<SpecialDiscount> getSpecialDiscount(String name,String type);

}
