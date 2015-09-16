package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hand.dao.CustomersInfoDao;
import com.hand.model.CustomersInfo;

@Repository
public class CustomersInfoDaoImpl implements CustomersInfoDao {
	
	@Resource
	private SessionFactory sessionFactory;

	public List<Integer> queryIdByCodeAndTypeAndName(CustomersInfo customersInfo) {
		Session session = sessionFactory.getCurrentSession();
		StringBuilder hql = new StringBuilder("select customer_id from customers_info where 1=1 ");
		List<String> params = new ArrayList<String>();
		List<Integer> customerIds = null;
		if(customersInfo.getCustomerCode() != null && !customersInfo.getCustomerCode().trim().equals("")){
			hql.append("and customer_code like ?");
			params.add(customersInfo.getCustomerCode());
		}
		if(customersInfo.getType() != null && !customersInfo.getType().trim().equals("")){
			hql.append("and type like ?");
			params.add(customersInfo.getType());
		}
		if(customersInfo.getCustomerName() != null && !customersInfo.getCustomerName().trim().equals("")){
			hql.append("and customer_name like ?");
			params.add(customersInfo.getCustomerName());
		}
		try {
			Query query = session.createSQLQuery(hql.toString());
			for(int i=0; i<params.size(); i++){
				query.setParameter(i, "%"+params.get(i)+"%");
			}
			customerIds = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerIds;
	}
}