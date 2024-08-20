package com.userapp.model;

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserDtls {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fullName;
	
	private String email;
	
	private String address;
	
	@Override
	public String toString() {
		return "UserDtls [id=" + id + ", fullName=" + fullName + ", email=" + email + ", address=" + address
				+ ", qualification=" + qualification + ", password=" + password + "]";
	}

	private String qualification;
	
	private String password;
	
	private String role;

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}

	public void setRole(String string) {
		// TODO Auto-generated method stub
		
	}

	

	
	}

	
	
	


