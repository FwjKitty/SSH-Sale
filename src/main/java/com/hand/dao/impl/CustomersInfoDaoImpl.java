package com.hand.dao.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.hand.dao.CustomersInfoDao;

import com.hand.model.Address;
import com.hand.model.Contactors;
import com.hand.model.CustomersInfo;
import com.hand.model.Organization;
import com.hand.model.Payment;

@Repository
@Transactional
public class CustomersInfoDaoImpl implements CustomersInfoDao{
	
	@Resource
	private SessionFactory sessionFactory;

	public List<CustomersInfo> findAllcustomers(String Cc,String Ty,String Cn,String St,String Gc,String Cor){
		List<CustomersInfo> customers = new ArrayList<CustomersInfo>();
		Session session =sessionFactory.getCurrentSession();
		String address_id= null;
		if(St !=null && !St.trim().equals("")){
			Query query1 = session.createSQLQuery("select address_Id from address where status = ?");
			query1.setParameter(0, St);
			address_id= query1.list().get(0).toString();
			System.out.println("address_id="+address_id);
			
			StringBuilder hql=new StringBuilder("from CustomersInfo where 1=1");
			List<String> params = new ArrayList<String>();
			if(Cc != null && !Cc.trim().equals("")){
				hql.append(" and customer_code like ?");
				params.add(Cc);
			}
			if(Ty != null && !Ty.trim().equals("")){
				hql.append(" and type like ?");
				params.add(Ty);
			}
			if(Cn != null && !Cn.trim().equals("")){
				hql.append(" and customer_name like ?");
				params.add(Cn);
			}
			if(address_id != null && !Cn.trim().equals("")){
			hql.append(" and address_id like ?");
			params.add(address_id);
				}
			if(Gc !=null && !Gc.trim().equals("")){
				hql.append(" and group_Company like ?");
				params.add(Gc);
			}
			if(Cor !=null && !Cor.trim().equals("")){
				hql.append(" and corporation like ?");
				params.add(Cor);
			}
			try {
				Query query2 = session.createQuery(hql.toString());
				for(int i=0; i<params.size(); i++){
					query2.setParameter(i, "%"+params.get(i)+"%");
				}
				customers=query2.list(); 
			} catch (Exception e) {
				e.printStackTrace();
			}

			return customers;
		}
		else{
		StringBuilder hql=new StringBuilder("from CustomersInfo where 1=1");
		List<String> params = new ArrayList<String>();
		if(Cc != null && !Cc.trim().equals("")){
			hql.append(" and customer_code like ?");
			params.add(Cc);
		}
		if(Ty != null && !Ty.trim().equals("")){
			hql.append(" and type like ?");
			params.add(Ty);
		}
		if(Cn != null && !Cn.trim().equals("")){
			hql.append(" and customer_name like ?");
			params.add(Cn);
		}

		if(Gc !=null && !Gc.trim().equals("")){
			hql.append(" and group_Company like ?");
			params.add(Gc);
		}
		if(Cor !=null && !Cor.trim().equals("")){
			hql.append(" and corporation like ?");
			params.add(Cor);
		}
		try {
			Query query = session.createQuery(hql.toString());
			for(int i=0; i<params.size(); i++){
				query.setParameter(i, "%"+params.get(i)+"%");
				
			}
			customers=query.list();
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
		}
	}
	public CustomersInfo getcustomer(int customerId){
		System.out.println("查找进入方法");
		CustomersInfo customer=new CustomersInfo();	
		Session session =sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CustomersInfo where customer_Id = ?");
		query.setParameter(0, customerId);
		List result = query.list();
		if (result.size()!=0) {
			customer = (CustomersInfo) query.list().get(0);
			System.out.println("查询客户"+customer.getCustomerId());
			System.out.println("查询客户方法"+customer.getCustomerCode());
		}
		return customer;
	}
	
	public Address getaddress(int customerId){
		System.out.println("进入GETaddress方法");
		Address address =new Address();
		int address_id=0;
		Session session =sessionFactory.getCurrentSession();
		Query query0=session.createSQLQuery("select address_id from customers_info where customer_id =?");
		query0.setParameter(0, customerId);
		List result0 = query0.list();
		System.out.println(query0.list());
		if (result0.size()!=0) {
			System.out.println("地址id size不等0");
			address_id = (Integer) query0.list().get(0);
			System.out.println("地址id="+address_id);
		}
		Query query = session.createQuery("from Address where address_id = ?");
		query.setParameter(0, address_id);
		List result = query.list();
		if (result.size()!=0) {
			address = (Address) query.list().get(0);
			System.out.println("方法"+address.getAddressLine1());
		}
		return address;
	}
	
	public Payment getpayment(int customerId){
		System.out.println("进入payment方法");
		Payment payment=new Payment();
		
		System.out.println( customerId);
		Session session =sessionFactory.getCurrentSession();
	
		Query query2=session.createQuery("from Payment where customer_Id ="+customerId);
		List result2=query2.list();
		System.out.println("q2"+query2.list());
		if (result2.size()!=0){
			payment=(Payment) query2.list().get(0);
			System.out.println(payment);
		}
		return payment;
	}
	
	public Organization getorganization(int customerId){
		System.out.println("进入方法org");
		int organization_id=0;
		Organization organization=new Organization();
		Session session =sessionFactory.getCurrentSession();
		
		Query query0=session.createSQLQuery("select organization_id from customers_info where customer_id =?");
		query0.setParameter(0, customerId);
		List result0 = query0.list();
		System.out.println(query0.list());
		if (result0.size()!=0) {
			System.out.println("地址id size不等0");
			organization_id = (Integer) query0.list().get(0);
			System.out.println("地址id="+organization_id);
		}
		
		Query query = session.createQuery("from Organization where organization_id = ?");
		try {
			query.setParameter(0, organization_id);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		List result = query.list();
		if (result.size()!=0) {
			organization = (Organization) query.list().get(0);
			System.out.println("org方法"+organization.getBusinessManager());
		}
		return organization;
	}
	
	public Contactors getcontactors(int customerId){
		System.out.println("进入Con方法");
		Contactors contactors=new Contactors();
		
		System.out.println("cn"+customerId);
		Session session =sessionFactory.getCurrentSession();
		
		Query query3=session.createQuery("from Contactors where customer_Id = ?");
		query3.setParameter(0, customerId);
		List result3=query3.list();
		System.out.println("q3"+query3.list());
		if (result3.size()!=0){
			contactors=(Contactors) query3.list().get(0);
			System.out.println(contactors);
		}
		return contactors;
	}

	public String add(String customerName, String customerCode, String type, String groupCompany, String corporation,
			String country, String state, String city, String addressLine1, String addressLine2, String postcode,
			String portOfDestination, String shippingMark, String status, Date inactiveDate, String invoiceGroup,
			String currency, String paymentTerm, String priceTerm1, String priceTerm2, String priceTerm3,
			String markupName, String discountName, String marketArea, String businessManager, String businessAssistant,
			String mailFrom, String prePoMailTo, String poMailTo, String ocpiMailTo, String invPklistMailto) {
		System.out.println("进入add 方法");
		System.out.println(country);
		Address address=new Address();
		address.setCountry(country);
		address.setState(state);
		address.setCity(city);
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setPostcode(postcode);
		address.setPortOfDestination(portOfDestination);
		address.setShippingMark(shippingMark);
		address.setStatus(status);
		address.setInactiveDate(inactiveDate);
		System.out.println("get"+address.getAddressLine1());
		Session session =sessionFactory.getCurrentSession();
		try{
		session.save(address);
		System.out.println(session.save(address));
		}catch(Exception e){
			e.printStackTrace();
		}
		Organization organization =new Organization();
		organization.setMarketArea(marketArea);
		organization.setBusinessManager(businessManager);
		organization.setBusinessAssistant(businessAssistant);
		System.out.println("or:"+organization.getBusinessAssistant());
		try{
			session.save(organization);
		}catch(Exception e){
			e.printStackTrace();
		}
		CustomersInfo customer=new CustomersInfo();
		customer.setCustomerName(customerName);
		customer.setCustomerCode(customerCode);
		customer.setType(type);
		customer.setGroupCompany(groupCompany);
		customer.setCorporation(corporation);
		customer.setAddress(address);
		customer.setOrganization(organization);
		System.out.println("customer.address="+customer.getAddress());
		try{
			session.save(customer);
		}catch(Exception e){
			e.printStackTrace();
		}
		Payment payment=new Payment();
		payment.setInvoiceGroup(invoiceGroup);
		payment.setCurrency(currency);
		payment.setPaymentTerm(paymentTerm);
		payment.setPriceTerm1(priceTerm1);
		payment.setPriceTerm2(priceTerm2);
		payment.setPriceTerm3(priceTerm3);
		payment.setMarkupName(markupName);
		payment.setDiscountName(discountName);
		payment.setCustomersInfo(customer);
		System.out.println("payment.customer.name="+payment.getCustomersInfo().getCustomerName());
		try{
			session.save(payment);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Contactors contactors=new Contactors();
		contactors.setMailFrom(mailFrom);
		contactors.setPrePoMailTo(prePoMailTo);
		contactors.setPoMailTo(poMailTo);
		contactors.setOcpiMailTo(ocpiMailTo);
		contactors.setInvPklistMailto(invPklistMailto);
		contactors.setCustomersInfo(customer);
		System.out.println("Ex"+contactors.getMailFrom());
		try{
			System.out.println("好了");
			session.save(contactors);
		}catch(Exception e){
			e.printStackTrace();
		}
			return "success";
	}
	
	public String update(int customerId,String customerName, String customerCode, String type, String groupCompany, String corporation,
			String country, String state, String city, String addressLine1, String addressLine2, String postcode,
			String portOfDestination, String shippingMark, String status, Date inactiveDate, String invoiceGroup,
			String currency, String paymentTerm, String priceTerm1, String priceTerm2, String priceTerm3,
			String markupName, String discountName, String marketArea, String businessManager, String businessAssistant,
			String mailFrom, String prePoMailTo, String poMailTo, String ocpiMailTo, String invPklistMailto) {
		System.out.println("进入update 方法");
		System.out.println(country);
		int address_id=0;
		Session session =sessionFactory.getCurrentSession();
		Query query0= session.createSQLQuery("select address_id from Customers_info where customer_id = ?");
		query0.setParameter(0, customerId);
		List result = query0.list();
		System.out.println(query0.list());
		if (result.size()!=0) {
			System.out.println("size不等0");
			address_id = (Integer) query0.list().get(0);
			System.out.println("地址id="+address_id);
		}
		Address address=(Address) session.get(Address.class, address_id);
		System.out.println("mijigyg");
		address.setCountry(country);
		address.setState(state);
		address.setCity(city);
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setPostcode(postcode);
		address.setPortOfDestination(portOfDestination);
		address.setShippingMark(shippingMark);
		address.setStatus(status);
		session.update(address); 
		
		int organization_id = 0;
		Query query1= session.createSQLQuery("select organization_id from customers_Info where customer_id = ?");
		query1.setParameter(0, customerId);
		List result1 = query1.list();
		System.out.println(query1.list());
		if (result1.size()!=0) {
			System.out.println("size不等0");
			organization_id = (Integer) query1.list().get(0);
			System.out.println("地址id="+organization_id);
		}
		Organization organization= (Organization) session.get(Organization.class, organization_id);
		System.out.println("mfrf");
		organization.setMarketArea(marketArea);
		organization.setBusinessManager(businessManager);
		organization.setBusinessAssistant(businessAssistant);
		session.update(organization); 
		
	/*	int customer_id=0;
		Query query3= session.createSQLQuery("select customer_Id from customers_info where customer_Name = ?");
		query3.setParameter(0, customerName);
		List result3 = query3.list();
		System.out.println(query3.list());
		if (result3.size()!=0) {
			System.out.println("size不等0");
			customer_id =  (Integer) query3.list().get(0);
			System.out.println("客户id="+customer_id);
		}*/
		CustomersInfo customer =(CustomersInfo) session.get(CustomersInfo.class, customerId);
		customer.setCustomerName(customerName);
		customer.setCustomerCode(customerCode);
		customer.setType(type);
		customer.setGroupCompany(groupCompany);
		customer.setCorporation(corporation);
		customer.setAddress(address);
		customer.setOrganization(organization);
		session.update(customer);
		
		Query query9=session.createQuery("from Payment where customer_id =?");
		query9.setParameter(0, customerId);
		List<Payment> list = query9.list();
		Payment payment=list.get(0);
		//Payment payment=(Payment) session.get(Payment.class, customerId);
		payment.setInvoiceGroup(invoiceGroup);
		payment.setCurrency(currency);
		payment.setPaymentTerm(paymentTerm);
		payment.setPriceTerm1(priceTerm1);
		payment.setPriceTerm2(priceTerm2);
		payment.setPriceTerm3(priceTerm3);
		payment.setMarkupName(markupName);
		payment.setDiscountName(discountName);
		payment.setCustomersInfo(customer);
		session.update(payment);
		
		
		
		Query query10=session.createQuery("from Contactors where customer_id =?");
		query10.setParameter(0, customerId);
		List<Contactors> list2 = query10.list();
		Contactors contactors=list2.get(0);
		//Contactors contactors=(Contactors) session.get(Contactors.class, customerId);
		contactors.setMailFrom(mailFrom);
		contactors.setPrePoMailTo(prePoMailTo);
		contactors.setPoMailTo(poMailTo);
		contactors.setOcpiMailTo(ocpiMailTo);
		contactors.setInvPklistMailto(invPklistMailto);
		contactors.setCustomersInfo(customer);
		session.update(contactors);

		return "success";
	}
	
	public boolean comfirm(int customerId){
		int address_id=0;
		Session session =sessionFactory.getCurrentSession();
		Query query0=session.createSQLQuery("select address_id from customers_info where customer_id =?");
		query0.setParameter(0, customerId);
		List result0 = query0.list();
		System.out.println(query0.list());
		if (result0.size()!=0) {
			System.out.println("地址id size不等0");
			address_id = (Integer) query0.list().get(0);
			System.out.println("地址id="+address_id);
		}
		Query query1=session.createSQLQuery("update address set status= ? where address_id=?");
		query1.setParameter(0,"确认");
		query1.setParameter(1, address_id);
		int result = query1.executeUpdate();
		if(result != 0){
			return true;
		}else{
			return false;
		}
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void update(CustomersInfo customer, int customerId) {
		// TODO Auto-generated method stub
		
	}

	public void add(CustomersInfo customer) {
		Session session =sessionFactory.getCurrentSession();
		try {
			System.out.println("进入add方法");
			session.save(customer);	
			
				//Query query=session.createSQLQuery("insert into Customer_(first_name,last_name,email,address_id,active,create_date,last_update,store_id) values (?,?,?,?,?,?,?,?)");
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