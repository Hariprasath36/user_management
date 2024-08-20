package com.userapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userapp.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls,Integer>{
	
	  public boolean existsByEmail(String email);

}
  