package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.NormalDiscountDao;
import com.hand.model.NormalDiscount;

@Repository
@Transactional
public class NormalDiscountDaoImpl implements NormalDiscountDao {

	@Resource
	private SessionFactory sessionFactory;
	
	
	public int getCount() {
		Session session = sessionFactory.getCurrentSession();
		int count=0;
	try {
		
		Object obj= session.createSQLQuery(" select count(1) from normal_discount ").uniqueResult();
		 count=Integer.parseInt(obj.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
		return count;
	}
	

	
	public List<NormalDiscount> getNormalDiscounts() {

		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from NormalDiscount").list();
	}

	
	public List<NormalDiscount> queryByPage(int pageSize, int pageNow) {
		
		List<NormalDiscount> list = null;
		if (pageSize > 0 && pageNow > 0) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from NormalDiscount");
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNow - 1) * pageSize);
			list = query.list();
		}
		return list;
	}

	public void update(NormalDiscount normalDiscount,int normalId) {
		try {
			
			System.out.println("更新daoimpl");
			System.out.println("normId" + normalDiscount.getNormalId());
			String hql = "update NormalDiscount cu set cu.discountName=?,cu.type=?,cu.discountBase=?,cu.baseQty=?,cu.discountRate=?,cu.activity=? where cu.normalId=?";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setString(0, normalDiscount.getDiscountName());
			query.setString(1, normalDiscount.getType());
			query.setString(2, normalDiscount.getDiscountBase());
			if( normalDiscount.getBaseQty()==null){
			query.setInteger(3, 0);
			}else{
				query.setInteger(3, normalDiscount.getBaseQty());
			}
			query.setDouble(4, normalDiscount.getDiscountRate());
			query.setString(5, normalDiscount.getActivity());
			query.setInteger(6, normalId);
			query.executeUpdate();
		

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public void save(NormalDiscount normalDiscount) {
		System.out.println("saveImp");
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(normalDiscount);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  List<NormalDiscount> getNormalDiscount(String name,String type){
		Session session = sessionFactory.getCurrentSession();
		
		StringBuilder hql = new StringBuilder(" from NormalDiscount where 1=1 ");
		List<String> params = new ArrayList<String>();
		List<NormalDiscount> list = null;
		
		System.out.println("name"+name+"type"+type);
		if(name != null){
			hql.append("and discountName like ? ");
			params.add(name);
		}
		System.out.println("type+"+type);
		if(type!="全部类型"&&!type.trim().equals("全部类型")){
			hql.append("and type like ?");
			params.add(type);
		}
		
		try {
			Query query = session.createQuery(hql.toString());
			System.out.println(query);
			for(int i=0; i<params.size(); i++){
				query.setParameter(i, "%"+params.get(i)+"%");
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("list+"+list);
		return list;
		
	}
	
	
}
