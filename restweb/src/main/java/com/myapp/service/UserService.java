package com.myapp.service;

import java.util.List;

import com.myapp.model.User;

public interface UserService {

	User getById(long Id);

	List<User> findAll();

	void add(User user);

	void delete(long Id);
	
	void update(User user);

}