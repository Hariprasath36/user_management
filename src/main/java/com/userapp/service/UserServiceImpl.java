package com.userapp.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.userapp.model.UserDtls;
import com.userapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDtls createUser(UserDtls user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("Role_USER");
		
		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		
		return userRepo.existsByEmail(email);
	}

	@Override
	public void createUser(User user) {
	    if (user.getPassword() == null || user.getPassword().isEmpty()) {
	        throw new IllegalArgumentException("Password cannot be null or empty");
	    }
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
	    // Other logic for saving the user
	}
}


	

	

	
	
	


