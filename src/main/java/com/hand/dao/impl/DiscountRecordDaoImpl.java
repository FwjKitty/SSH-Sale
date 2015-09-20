package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.DiscountRecordDao;
import com.hand.model.CustomersInfo;
import com.hand.model.DiscountAppliedRecords;
import com.hand.model.SpecialDiscount;

@Repository
@Transactional
public class DiscountRecordDaoImpl implements DiscountRecordDao{

	@Resource
	private SessionFactory sessionFactory;
	
	public List<DiscountAppliedRecords> getDiscounts(int id) {
		SpecialDiscount sp=new SpecialDiscount();
		sp.setDiscountId(id);
		System.out.println("cusImp");
		List<DiscountAppliedRecords> list=new ArrayList<DiscountAppliedRecords>();
		list= sessionFactory.getCurrentSession().createQuery(" from DiscountAppliedRecords where discount_id= ?").setParameter(0,sp.getDiscountId()).list();
		System.out.println(list);
		return  list;
	}

}
