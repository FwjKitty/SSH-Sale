package com.hand.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hand.dao.NormalDiscountDao;
import com.hand.dao.UserDao;
import com.hand.model.User;
import com.hand.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public int getCount() {
		int count=userDao.getCount();
		return count;
	}

	public List<User> getNormalDiscountsByPage(int pageSize, int pageNow) {
		
		return userDao.queryByPage(pageSize, pageNow);
	}

	public void add(User user) {
		userDao.save(user);
	}

}
