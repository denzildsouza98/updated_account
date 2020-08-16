package com.icinbank.service;

import com.icinbank.model.User;
import com.icinbank.model.UserDisplay;

public interface ProfileService {
	public User updateUser(User user);
	public User getUser(String username);
	public UserDisplay userDisplay(String username);

}
