package com.hand.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.PriceListDao;
import com.hand.model.PriceList;

@Repository
@Transactional
public class PriceListDaoImpl implements PriceListDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public List<PriceList> queryByPage(int pageSize, int pageNow) {
		List<PriceList> list = null;
		if (pageSize > 0 && pageNow > 0) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from PriceList");
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNow-1) * pageSize);
			list = query.list();
		}
		return list;
	}

	public List<PriceList> queryAll() {
		List<PriceList> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PriceList");
		list = query.list();
		return list;
	}

	public int getCount() {
		Session session = sessionFactory.getCurrentSession();
		int count=0;
		try {
			Object obj= session.createSQLQuery("select count(1) from  price_list").uniqueResult();
			count=Integer.parseInt(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}