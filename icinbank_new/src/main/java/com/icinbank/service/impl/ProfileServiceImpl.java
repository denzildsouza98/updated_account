package com.icinbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinbank.dao.UserDisplayRepository;
import com.icinbank.dao.UserRepository;
import com.icinbank.model.User;
import com.icinbank.model.UserDisplay;
import com.icinbank.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private UserRepository dao;
	
	@Autowired
	private UserDisplayRepository userDisplayDao;

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
				return dao.save(user);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
				return dao.findByUsername(username);

	}

	@Override
	public UserDisplay userDisplay(String username) {
		UserDisplay user=userDisplayDao.getCurrentUser(username);
		return user;
	}
	}

