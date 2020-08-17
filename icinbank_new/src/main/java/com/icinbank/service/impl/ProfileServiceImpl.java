package com.icinbank.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinbank.dao.UserDisplayRepository;
import com.icinbank.dao.UserRepository;
import com.icinbank.details.UpdateDetails;
import com.icinbank.model.User;
import com.icinbank.model.UserDisplay;
import com.icinbank.response.UpdateResponse;
import com.icinbank.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired
	private UserRepository dao;
	
	@Autowired
	private UserDisplayRepository userDisplayDao;

	@Override
	public UpdateResponse updateUser(UpdateDetails user) {
			UpdateResponse response=new UpdateResponse();
			User u=dao.findByUsername(user.getUsername());
			boolean flag=true;
			String message="Update Successfull"; 
			int counter =0;
			
			if(user.getAddress()!=null) {
				u.setAddress(user.getAddress());
				counter++;
			}
			
			if(user.getNewpassword()!=null && user.getPassword()==null) {
				flag=false;
				message="to update your password provide the old password";
			}
			
			if(user.getPassword()!=null && user.getNewpassword()!=null) {
				String hashedPassword = DigestUtils.sha256Hex(user.getPassword());
				if(hashedPassword.equals(u.getPassword())) 
				{
				String newPassword = DigestUtils.sha256Hex(user.getNewpassword());
				u.setPassword(newPassword);
				counter++;
				}
				else {
					flag=false;
					message="please enter the previous password correctly to update your password";
					counter++;
				}
				
			}
			if(user.getEmail()!=null) {
				u.setEmail(user.getEmail());
				counter++;
			}
			if(user.getPhone()!=0) {
				u.setPhone(user.getPhone());
				counter++;
			}
			if(counter==0) {
				flag=false;
				message="Update failed ";
			}
			 dao.save(u);
			 response.setFlag(flag);
			 response.setMessage(message);
			 
			 return response;
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

