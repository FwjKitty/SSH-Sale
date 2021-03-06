package com.hand.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.dao.PriceListDao;
import com.hand.model.PriceList;
import com.hand.model.PriceListConfig;

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

	public JsonArray queryByCustomerIdAndHyItemAndActivity(List<Integer> customerIds,
			PriceList priceList,List<PriceListConfig> priceListConfigs) {
		Session session = sessionFactory.getCurrentSession();
		StringBuilder columns = new StringBuilder();
		JsonArray jsonArray = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("price_list_id", "price_list_id");
		jsonObject.addProperty("customersInfo.customerId", "customersInfo.customerId");
		columns.append("price_list_id,customer_id,");
		for(int i=0; i<priceListConfigs.size(); i++){
			jsonObject.addProperty(priceListConfigs.get(i).getPriceListCol(),priceListConfigs.get(i).getDisplayName());
			if(i == priceListConfigs.size()-1){
				columns.append(priceListConfigs.get(i).getPriceListCol());
			}else{
				columns.append(priceListConfigs.get(i).getPriceListCol()+",");
			}
		}
		StringBuilder sql = new StringBuilder("select "+columns+" from price_list where 1=1");
		if(!priceList.getHy_item().equals("") && priceList.getHy_item() != null){
			sql.append(" and hy_item like %"+priceList.getHy_item()+"%");
		}
		sql.append(" and customer_id in (:customerIds)");
		try {
			Query query = session.createSQLQuery(sql.toString());
			query.setParameterList("customerIds", customerIds);
			List<Object[]> list = query.list();
			for(Object[] obj : list){
				jsonObject = new JsonObject();
				for(int i=0; i<priceListConfigs.size(); i++){
					if(i == 0){
						jsonObject.addProperty("price_list_id",obj[i].toString());
					}else if(i == 1){
						jsonObject.addProperty("customersInfo.customerId",obj[i].toString());
					}else{
						jsonObject.addProperty(priceListConfigs.get(i-1).getPriceListCol(),obj[i].toString());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

	public JsonArray queryByCustomerIdAndActivity(List<Integer> customerIds,
			List<PriceListConfig> priceListConfigs) {
		Session session = sessionFactory.getCurrentSession();
		StringBuilder columns = new StringBuilder();
		JsonArray jsonArray = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("price_list_id", "price_list_id");
		jsonObject.addProperty("customersInfo.customerId", "customersInfo.customerId");
		columns.append("price_list_id,customer_id,");
		for(int i=0; i<priceListConfigs.size(); i++){
			jsonObject.addProperty(priceListConfigs.get(i).getPriceListCol(),priceListConfigs.get(i).getDisplayName());
			if(i == priceListConfigs.size()-1){
				columns.append(priceListConfigs.get(i).getPriceListCol());
			}else{
				columns.append(priceListConfigs.get(i).getPriceListCol()+",");
			}
		}
		jsonArray.add(jsonObject);
		StringBuilder sql = new StringBuilder("select "+columns+" from price_list where 1=1");
		sql.append(" and customer_id in (:customerIds)");
		try {
			Query query = session.createSQLQuery(sql.toString());
			query.setParameterList("customerIds", customerIds);
			List<Object[]> list = query.list();
			for(Object[] obj : list){
				jsonObject = new JsonObject();
				for(int i=0; i<obj.length; i++){
					if(i == 0){
						jsonObject.addProperty("price_list_id",obj[i].toString());
					}else if(i == 1){
						jsonObject.addProperty("customersInfo.customerId",obj[i].toString());
					}else{
						jsonObject.addProperty(priceListConfigs.get(i-2).getPriceListCol(),obj[i].toString());
					}
				}
				jsonArray.add(jsonObject);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	public int update(List<PriceList> priceLists) {
		Session session = sessionFactory.getCurrentSession();
		//Transaction tx = session.getTransaction();
		try{
			for(PriceList priceList : priceLists){
				session.update(priceList);
				//tx.commit();
			}
		}catch(Exception e){
			e.printStackTrace();
			//tx.rollback();
			return 0;
		}
		return 1;
	}

	public int save(List<PriceList> priceLists) {
		Session session = sessionFactory.getCurrentSession();
		//Transaction tx = session.getTransaction();
		try{
			for(PriceList priceList : priceLists){
				session.save(priceList);
				//tx.commit();
			}
		}catch(Exception e){
			e.printStackTrace();
			//tx.rollback();
			return 0;
		}
		return 1;
	}

	public List<Object[]> queryByPriceListColAndPriceListId(String priceListCol,
			List<Integer> priceListIds) {
		List<Object[]> list = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createSQLQuery("select "+priceListCol+" from price_list where price_list_id in (:priceListIds)");
			query.setParameterList("priceListIds", priceListIds);
			JsonArray jsonArray = new JsonArray();
			JsonObject jsonObject = new JsonObject();
			list = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}