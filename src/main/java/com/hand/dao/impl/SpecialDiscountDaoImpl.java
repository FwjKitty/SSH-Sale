package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.SpecialDiscountDao;
import com.hand.model.CustomersInfo;
import com.hand.model.Organization;
import com.hand.model.SpecialDiscount;
import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;

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
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(specialDiscount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 权限查询语句
	public List<SpecialDiscount> getSpecialDiscount(String name, String type,
			String loginName) {
		Session session = sessionFactory.getCurrentSession();
		List<SpecialDiscount> list = null;
		List<String> list4 = null;
		List<String> list5 = null;
		
		if (ServletActionContext.getRequest().getSession()
				.getAttribute("roleName").toString().trim().equals("业务经理")) {
			List<Integer> list3 = new ArrayList<Integer>();
			list4 = new ArrayList<String>();
			list5 = new ArrayList<String>();
			List<Organization> list2 = queryByName(loginName);
			Organization organization = new Organization();
			for (int i = 0; i < list2.size(); i++) {
				int originID = list2.get(i).getOrganizationId();
				list3.add(originID);
				list4 = session.createSQLQuery(
						"select customer_code from Customers_info where organization_id ='"
								+ originID + "'").list();
				list5.addAll(list4);
			}
		} else if (ServletActionContext.getRequest().getSession()
				.getAttribute("roleName").toString().trim().equals("业务员")) {
			List<Integer> list3 = new ArrayList<Integer>();
			list4 = new ArrayList<String>();
			list5 = new ArrayList<String>();
			List<Organization> list2 = queryByName1(loginName);
			Organization organization = new Organization();
			for (int i = 0; i < list2.size(); i++) {
				int originID = list2.get(i).getOrganizationId();
				list3.add(originID);
				list4 = session.createSQLQuery(
						"select customer_code from Customers_info where organization_id ='"
								+ originID + "'").list();
				list5.addAll(list4);
			}
		}

		Query query = null;
		StringBuilder hql = new StringBuilder(" from SpecialDiscount where 1=1");

		List<String> params = new ArrayList<String>();

		if (name != null && !name.trim().equals("")) {

			hql.append(" and discountName like ?");
			params.add(name);

		}

		// 主语句
		if (type != null && !type.trim().equals("")) {
			for (int i = 0; i < list5.size(); i++) {
				// 进行筛选
				if (list5.get(i).trim().equals(type)) {
					hql.append(" and customerCode ='" + type + "'");
				} else if (!list5.get(i).trim().equals(type)
						&& i == list5.size() - 1) {
					hql.append(" and customerCode in (:customerCodes1)");
				}
			}
		} else {
			hql.append(" and customerCode in (:customerCodes)");
		}
		try {
			query = session.createQuery(hql.toString());
			int i = 0;
			for (i = 0; i < params.size(); i++) {
				query.setParameter(i, "%" + params.get(i) + "%");
			}
			if (type != null && !type.trim().equals("")) {
				for (int k = 0; k < list5.size(); k++) {
					// 进行筛选
					if (list5.get(k).trim().equals(type)) {

					} else if (!list5.get(k).trim().equals(type)
							&& k == list5.size() - 1) {
						query.setParameterList("customerCodes1", list5);
					}
				}
			} else {
				query.setParameterList("customerCodes", list5);
			}
			list = query.list();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public int queryCustomerId(String customerCode) {
		Session session = sessionFactory.getCurrentSession();
		Object obj = session.createSQLQuery(
				"select customer_id from Customers_info where customer_code ='"
						+ customerCode + "'").uniqueResult();
		return Integer.parseInt(obj.toString());

	}

		//查询业务经理权限
	public List<Organization> queryByName(String username) {
		Session session = sessionFactory.getCurrentSession();

		try {
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return session
				.createQuery("from Organization where businessManager =?")
				.setParameter(0, username).list();
	}

		//查询业务员权限
	public List<Organization> queryByName1(String username) {
		Session session = sessionFactory.getCurrentSession();

		try {
		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return session
				.createQuery("from Organization where businessAssistant =?")
				.setParameter(0, username).list();
	}

}
