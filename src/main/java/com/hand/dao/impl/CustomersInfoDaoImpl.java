package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.hand.dao.CustomersInfoDao;

import com.hand.model.Address;

import com.hand.model.CustomersInfo;

@Repository
@Transactional
public class CustomersInfoDaoImpl implements CustomersInfoDao{
	
	@Resource
	private SessionFactory sessionFactory;

	public CustomersInfo getCustomer(int customerId) {
		CustomersInfo customer = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where customer_id = "
				+ customerId);
		List result = query.list();
		if (result.size() == 1) {
			customer = (CustomersInfo) query.list().get(0);
		}
		return customer;
	}

/*	public List<String> getCustomers() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Customer").list();
	}*/


	public List<CustomersInfo> findAllcustomers(String customerCode, String type, String customerName,String status,String groupCompany,String corporation){
		List<CustomersInfo> customers = new ArrayList<CustomersInfo>();
		Session session =sessionFactory.getCurrentSession();
		//List <Object> ao=new ArrayList<Object>();
		//StringBuilder hql = new StringBuilder("select customer_name,customer_code,country,status,business_manager,business_assistant from Customers_Info,address,organization where Customers_Info.address_id=address.address_id and Customers_Info.organization_id=organization.organization_id ");


		//StringBuilder hql=new StringBuilder("from CustomersInfo,Address,Organization where 1=1 ");
		
		StringBuilder hql=new StringBuilder("from CustomersInfo where 1=1");
		List<String> params = new ArrayList<String>();
		if(customerCode != null && !customerCode.trim().equals("")){
			hql.append(" and customer_code like ?");
			params.add(customerCode);
		}
		if(type != null && !type.trim().equals("")){
			hql.append(" and type like ?");
			params.add(type);
		}
		if(customerName != null && !customerName.trim().equals("")){
			hql.append(" and customer_name like ?");
			params.add(customerName);
		}
		if(status != null && !status.trim().equals("")){
			hql.append(" and status like ?");
			params.add(status);
		}
		if(groupCompany !=null && !groupCompany.trim().equals("")){
			hql.append(" and group_Company like ?");
			params.add(groupCompany);
		}
		if(corporation !=null && !corporation.trim().equals("")){
			hql.append(" and corporation like ?");
			params.add(corporation);
		}
		try {
			Query query = session.createQuery(hql.toString());
			for(int i=0; i<params.size(); i++){
				query.setParameter(i, "%"+params.get(i)+"%");
				//System.out.println(params.get(i));
			}
	/*		System.out.println(query.list());
			List list = query.list();
			Iterator i = list.iterator();
			 while(i.hasNext()){
				 customers.add((CustomersInfo) i.next());
				 System.out.println("customerinfo表查询成功");
			 }*/
		
			//System.out.println("a:"+list.get(0).getAddress().getAddressLine1());
			//String country = list.get(0).getAddress().getCountry();
			customers=query.list();
			//address_id=query.list().get(0).getaddress_id;
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("customers"+customers);
		System.out.println("customerinfo表查询成功");
		return customers;
		
	}



	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
//
//	public List<CustomersInfo> queryByPage(int pageSize, int pageNow) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void update(CustomersInfo customer, int customerId) {
		// TODO Auto-generated method stub
		
	}

	public void add(CustomersInfo customer) {
		Session session =sessionFactory.getCurrentSession();
		try {
			session.save(customer);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(CustomersInfo customer) {
		// TODO Auto-generated method stub
		
	}

	public List<CustomersInfo> queryByPage(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		return null;
	}


/*
	public Customer getCustomer(String firstName, String password) {
		return (Customer) sessionFactory.getCurrentSession()
				.createQuery("from Customer where username=? and password=?")
				.setParameter(0, firstName).setParameter(1, password)
				.uniqueResult();
	}


	public Customer getCustomer(String firstName) {
		return (Customer) sessionFactory.getCurrentSession()
				.createQuery("from Customer where firstName=?")
				.setParameter(0, firstName).uniqueResult();
	}


	public int getCount() {
		System.out.println("count----------");
		Session session = sessionFactory.getCurrentSession();
		int count=0;
	try {
		
		Object obj= session.createSQLQuery(" select count(1) from  Customer ").uniqueResult();
		 count=Integer.parseInt(obj.toString());
	} catch (Exception e) {
		e.printStackTrace();
	}
		return count;
	}
	


	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Customer").list();
	}

	public List<Customer> queryByPage(int pageSize, int pageNow) {

		List<Customer> list = null;
		if (pageSize > 0 && pageNow > 0) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Customer");
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNow-1) * pageSize);
			list = query.list();
		}
		return list;

	}

	public boolean update(String hql) {
		boolean result = true;
		Query query = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			query = session.createQuery(hql);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			session.close();
		}
		return result;
	}

	public boolean updateSQL(String sql) {
		boolean result = true;
		Query query = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			query = session.createSQLQuery(sql);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			session.close();
		}
		return result;
	}

	// 查询
	public List select(String hql) {
		List result = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			Query query = session.createQuery(hql);
			result = query.list();
			session.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return result;
	}

	// 得到ID
	public Customer getCustomer(Short customerId) {
		Customer customer = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Customer where customerId = "
				+ customerId);
		List result = query.list();
		if (result.size() == 1) {
			customer = (Customer) query.list().get(0);
		}
		return customer;
	}

	public Object getCustomerTest(Class ob, Short customerId) {
		Object result = null;
		Transaction tx = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			tx = session.beginTransaction();
			result = session.get(ob, customerId);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			result = null;
		} finally {
			session.close();
		}

		return result;
	}

	
	public void update(Customer customer,short addressid) {
		try {
			System.out.println("更新daoimpl");
			System.out.println("emali" + customer.getEmail());
			String hql = "update Customer cu set cu.firstName=?,cu.lastName=?,cu.email=?,cu.address=? where cu.customerId=?";
			Session session = sessionFactory.getCurrentSession();
			// Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			query.setString(0, customer.getFirstName());
			query.setString(1, customer.getLastName());
			query.setString(2, customer.getEmail());
			query.setShort(3, addressid);
			query.setShort(4, customer.getCustomerId());
			query.executeUpdate();

			System.out.println("emali" + customer.getFirstName()
					+ customer.getLastName());

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}



	public void add(Customer customer) {
		// TODO Auto-generated method stub
		
	}


	public void save(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(customer);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void delete(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
	}

	*/
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