package com.icinbank.service;

import com.icinbank.details.UpdateDetails;
import com.icinbank.model.User;
import com.icinbank.model.UserDisplay;

public interface ProfileService {
	public User updateUser(UpdateDetails user);
	public User getUser(String username);
	public UserDisplay userDisplay(String username);

}
