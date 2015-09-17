package com.hand.dao;

import java.util.List;

import com.hand.model.Address;
import com.hand.model.CustomersInfo;
import com.hand.model.SpecialDiscount;

public interface SpecialDiscountDao {
	
	public abstract int getCount();
	public abstract List<SpecialDiscount> getSpecialDiscounts();
	public abstract List<SpecialDiscount> queryByPage(int pageSize, int pageNow);
	public abstract void update(SpecialDiscount specialDiscount, int normalId);
	public abstract void save(SpecialDiscount specialDiscount);
	public abstract List<SpecialDiscount> getSpecialDiscount(String name,String type);
	public abstract int queryCustomerId(String customerCode);
	

}
