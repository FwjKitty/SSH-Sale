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

import com.hand.dao.SpecialDiscountDao;
import com.hand.model.Address;
import com.hand.model.CustomersInfo;
import com.hand.model.NormalDiscount;
import com.hand.model.SpecialDiscount;

@Repository
@Transactional
public class SpecialDiscountDaoImpl implements SpecialDiscountDao {

	@Resource
	private SessionFactory sessionFactory;

	public int getCount() {
		Session session = sessionFactory.getCurrentSession();
		int count = 0;
		try {

			Object obj = session.createSQLQuery(
					" select count(1) from special_discount ").uniqueResult();
			count = Integer.parseInt(obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public List<SpecialDiscount> getSpecialDiscounts() {

		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from SpecialDiscount").list();
	}

	public List<SpecialDiscount> queryByPage(int pageSize, int pageNow) {

		System.out.println("nd-impl");
		List<SpecialDiscount> list = null;
		if (pageSize > 0 && pageNow > 0) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from SpecialDiscount");
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNow - 1) * pageSize);
			list = query.list();
		}
		return list;
	}

	public void update(SpecialDiscount specialDiscount, int specialDiscountId) {
		try {

			System.out.println("更新daoimpl");
			System.out.println("specialDiscountId"
					+ specialDiscount.getDiscountId());
			String hql = "update SpecialDiscount cu set cu.discountName=?,cu.amount=?,cu.appliedAmount=?,cu.balance=?,cu.activity=? where cu.discountId=?";
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setString(0, specialDiscount.getDiscountName());
			query.setString(1, specialDiscount.getAmount());
			query.setLong(2, specialDiscount.getAppliedAmount());
			query.setLong(3, specialDiscount.getBalance());
			query.setString(4, specialDiscount.getActivity());
			query.setInteger(5, specialDiscountId);
			query.executeUpdate();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public void save(SpecialDiscount specialDiscount) {
		System.out.println("saveImp");
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(specialDiscount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SpecialDiscount> getSpecialDiscount(String name, String type) {
		System.out.println("daoImpl查");
		Session session = sessionFactory.getCurrentSession();
		// List<NormalDiscount> list=null;
		// String hql="from NormalDiscount where discountName like "+name;
		// String hql1="from NormalDiscount where type like "+type;
		// String
		// hql2="from NormalDiscount where discountName like "+name+"AND type like"+type;
		// if(name==""&&type!=""){
		// list=session.createQuery(hql).list();
		// }else if(type=="全部类型"&&name!=""){
		// list=session.createQuery(hql1).list();
		// }
		// else{
		// list=session.createQuery(hql2).list();
		// }
		// System.out.println("list+"+list);

		StringBuilder hql = new StringBuilder(
				" from SpecialDiscount where 1=1 ");
		List<String> params = new ArrayList<String>();
		List<SpecialDiscount> list = null;

		System.out.println("name" + name + "type" + type);
		if (name != null) {
			hql.append("and discountName like ? ");
			params.add(name);
		}
		if (type != null) {
			hql.append("and customerCode like ?");
			params.add(type);
		}

		try {
			Query query = session.createQuery(hql.toString());
			System.out.println(query);
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i, "%" + params.get(i) + "%");
			}
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("list+" + list);
		return list;

	}

	public int queryCustomerId(String customerCode) {
		Session session = sessionFactory.getCurrentSession();
		Object obj = session.createSQLQuery(
				"select customer_id from Customers_info where customer_code ='"
						+ customerCode + "'").uniqueResult();
		return Integer.parseInt(obj.toString());

	}

}
