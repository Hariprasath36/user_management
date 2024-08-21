package com.userapp.service;

import org.apache.catalina.User;

import com.userapp.model.UserDtls;

public interface UserService {
	
	public UserDtls createUser(UserDtls user);
	
	public boolean checkEmail(String email);

	void createUser(User user);
	
	

}
