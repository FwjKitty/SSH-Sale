package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.PriceListConfigDao;
import com.hand.model.PriceListConfig;

@Repository
@Transactional
public class PriceListConfigDaoImpl implements PriceListConfigDao {

	@Resource
	private SessionFactory sessionFactory;
	
	public List<PriceListConfig> queryByPage(int pageSize, int pageNow) {
		List<PriceListConfig> list = null;
		if (pageSize > 0 && pageNow > 0) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from PriceListConfig");
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNow-1) * pageSize);
			list = query.list();
		}
		return list;
	}

	public List<PriceListConfig> queryAll() {
		List<PriceListConfig> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PriceListConfig");
		list = query.list();
		return list;
	}

	public int getCount() {
		Session session = sessionFactory.getCurrentSession();
		int count=0;
		try {
			Object obj= session.createSQLQuery("select count(1) from price_list_config").uniqueResult();
			count=Integer.parseInt(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<PriceListConfig> queryByActivity(String activity) {
		List<PriceListConfig> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PriceListConfig where activity=?");
		query.setParameter(0, activity);
		list = query.list();
		return list;
	}

	public List<PriceListConfig> queryByExcelCol(int excelCol) {
		List<PriceListConfig> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PriceListConfig where excel_col=?");
		query.setParameter(0, excelCol);
		list = query.list();
		return list;
	}

	public List<PriceListConfig> queryByDisplayName(String displayName) {
		List<PriceListConfig> list = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from PriceListConfig where display_name like ?");
		query.setParameter(0, "%"+displayName+"%");
		list = query.list();
		return list;
	}

	public List<PriceListConfig> queryByActivityAndExcelColAndDisplayName(PriceListConfig priceListConfig,int pageSize,int pageNow) {
		Session session = sessionFactory.getCurrentSession();
		StringBuilder hql = new StringBuilder("from PriceListConfig where 1=1");
		List<String> params1 = new ArrayList<String>();
		List<String> params2 = new ArrayList<String>();
		List<PriceListConfig> priceListConfigs = null;
		if(priceListConfig.getActivity() != null && !priceListConfig.getActivity().trim().equals("")){
			hql.append(" and activity = ?");
			params1.add(priceListConfig.getActivity());
		}
		if(priceListConfig.getExcelCol() != null){
			hql.append(" and excel_col = ?");
			params1.add(priceListConfig.getExcelCol().toString());
		}
		if(priceListConfig.getDisplayName() != null && !priceListConfig.getDisplayName().trim().equals("")){
			hql.append(" and display_name like ?");
			params2.add(priceListConfig.getDisplayName());
		}
		try {
			Query query = session.createQuery(hql.toString());
			int i=0;
			for(; i<params1.size(); i++){
				query.setParameter(i, params1.get(i));
			}
			for(int j=0; j<params2.size(); j++){
				query.setParameter(i, "%"+params2.get(i)+"%");
				i++;
			}
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNow-1) * pageSize);
			priceListConfigs = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceListConfigs;
	}

	public List<PriceListConfig> queryByCustomerIdAndActivityAndExcelColAndDisplayName(List<Integer> customerIds,PriceListConfig priceListConfig,int pageSize,int pageNow) {
		Session session = sessionFactory.getCurrentSession();
		StringBuilder hql = new StringBuilder("from PriceListConfig where 1=1");
		List<String> params1 = new ArrayList<String>();
		List<String> params2 = new ArrayList<String>();
		List<PriceListConfig> priceListConfigs = null;
		if(!priceListConfig.getActivity().equals("全部")){
			hql.append(" and activity = ?");
			System.out.println("1");
			params1.add(priceListConfig.getActivity());
		}
		if(priceListConfig.getExcelCol() != null){
			hql.append(" and excel_col = ?");
			System.out.println("2");
			params1.add(priceListConfig.getExcelCol().toString());
		}
		if(priceListConfig.getDisplayName() != null && !priceListConfig.getDisplayName().trim().equals("")){
			hql.append(" and display_name like ?");
			System.out.println("3");
			params2.add(priceListConfig.getDisplayName());
		}
		hql.append(" and customer_id in (:customerIds)");
		try {
			Query query = session.createQuery(hql.toString());
			int i=0;
			for(; i<params1.size(); i++){
				query.setParameter(i, params1.get(i));
			}
			for(int j=0; j<params2.size(); j++){
				query.setParameter(i, "%"+params2.get(i)+"%");
				i++;
			}
			query.setParameterList("customerIds", customerIds);
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNow-1) * pageSize);
			priceListConfigs = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return priceListConfigs;
	}

	public int save(PriceListConfig priceListConfig) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println((Integer) session.save(priceListConfig));
		return (Integer) session.save(priceListConfig);
	}
}