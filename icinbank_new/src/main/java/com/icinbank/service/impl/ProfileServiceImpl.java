package com.icinbank.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinbank.dao.UserDisplayRepository;
import com.icinbank.dao.UserRepository;
import com.icinbank.details.UpdateDetails;
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
	public User updateUser(UpdateDetails user) {
			
			User u=dao.findByUsername(user.getUsername());
			
			if(user.getAddress()!=null) {
				u.setAddress(user.getAddress());
			}
			if(user.getPassword()!=null && user.getNewpassword()!=null) {
				String hashedPassword = DigestUtils.sha256Hex(user.getPassword());
				if(hashedPassword.equals(u.getPassword())) 
				{
				String newPassword = DigestUtils.sha256Hex(user.getNewpassword());
				u.setPassword(newPassword);
				}
				
			}
			if(user.getEmail()!=null) {
				u.setEmail(user.getEmail());
			}
			if(user.getPhone()!=0) {
				u.setPhone(user.getPhone());
			}
			return dao.save(u);
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

