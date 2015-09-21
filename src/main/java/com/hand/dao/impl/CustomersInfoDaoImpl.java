package com.hand.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hand.dao.CustomersInfoDao;
import com.hand.model.Address;
import com.hand.model.Contactors;
import com.hand.model.CustomersInfo;
import com.hand.model.Organization;
import com.hand.model.Payment;

@Repository
public class CustomersInfoDaoImpl implements CustomersInfoDao {
	
	@Resource
	private SessionFactory sessionFactory;


	public List<CustomersInfo> findAllcustomers(String customerCode,
			String type, String customerName, String status,
			String groupCompany, String corporation) {
		// TODO Auto-generated method stub
		return null;
	}

	public Address getaddress(String country) {
		// TODO Auto-generated method stub
		return null;
	}

	public Payment getpayment(String customerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Organization getorganization(String businessManager) {
		// TODO Auto-generated method stub
		return null;
	}

	public Contactors getcontactors(String customerName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String add(String customerName, String customerCode, String type,
			String groupCompany, String corporation, String country,
			String state, String city, String addressLine1,
			String addressLine2, String postcode, String portOfDestination,
			String shippingMark, String status, Date inactiveDate,
			String invoiceGroup, String currency, String paymentTerm,
			String priceTerm1, String priceTerm2, String priceTerm3,
			String markupName, String discountName, String marketArea,
			String businessManager, String businessAssistant, String mailFrom,
			String prePoMailTo, String poMailTo, String ocpiMailTo,
			String invPklistMailto) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean comfirm(String status) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<CustomersInfo> queryByPage(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(CustomersInfo customer, int customerId) {
		// TODO Auto-generated method stub
		
	}

	public void add(CustomersInfo customer) {
		// TODO Auto-generated method stub
		
	}

	public void delete(CustomersInfo customer) {
		// TODO Auto-generated method stub
		
	}
	
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

	public List<CustomersInfo> queryCustomerCodes() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CustomersInfo");
		List<CustomersInfo> customersInfos = query.list();
		return customersInfos;
	}
	
	
}