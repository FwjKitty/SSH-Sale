package com.hand.dao;

import java.util.List;

import com.hand.model.DiscountAppliedRecords;


public interface DiscountRecordDao {
	
	public abstract List<DiscountAppliedRecords> getDiscounts(int id);
}
