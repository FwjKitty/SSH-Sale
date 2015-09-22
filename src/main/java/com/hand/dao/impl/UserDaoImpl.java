package com.hand.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.UserDao;
import com.hand.model.NormalDiscount;
import com.hand.model.Role;
import com.hand.model.User;
@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
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
	
	
public List<User> queryByPage(int pageSize, int pageNow) {
		
		List<User> list = null;
		if (pageSize > 0 && pageNow > 0) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from User");
			query.setMaxResults(pageSize);
			query.setFirstResult((pageNow - 1) * pageSize);
			list = query.list();
		}
		return list;
	}
	
public void save(User user) {
	Session session = sessionFactory.getCurrentSession();
	try {
		session.save(user);
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public  List<Role> getRole(){
	Session session = sessionFactory.getCurrentSession();
	return session.createQuery("from Role ").list();
}


@Override
public User getUser(String username) {
	Session session = sessionFactory.getCurrentSession();
	return (User) session.createQuery("from User where username=?").setParameter(0, username).uniqueResult();
}


}
