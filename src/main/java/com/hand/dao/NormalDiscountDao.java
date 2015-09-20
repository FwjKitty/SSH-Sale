package com.hand.dao;

import java.util.List;

import com.hand.model.NormalDiscount;

public interface NormalDiscountDao {
	
	public abstract int getCount();
	public abstract List<NormalDiscount> getNormalDiscounts();
	public abstract List<NormalDiscount> queryByPage(int pageSize, int pageNow);
	public abstract void update(NormalDiscount normalDiscount, int normalId);
	public abstract void save(NormalDiscount normalDiscount);
	public abstract List<NormalDiscount> getNormalDiscount(String name,String type);

}
