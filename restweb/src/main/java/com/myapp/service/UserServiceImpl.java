package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.UserDao;
import com.myapp.model.User;


@Service
@Transactional
public class UserServiceImpl implements UserService { 

	@Autowired
	private UserDao userDao;

	@Override
	public User getById(long Id) { 

		return userDao.getById(Id);
	}

	@Override
	
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override

	public void add(User user) {
		userDao.add(user);

	}

	@Override
	public void delete(long Id) {
		userDao.delete(Id);

	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}



}
