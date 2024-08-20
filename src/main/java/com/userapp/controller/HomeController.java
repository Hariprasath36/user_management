package com.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.userapp.model.UserDtls;
import com.userapp.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@PostMapping("/createUser")
	public String createuser(@ModelAttribute UserDtls user)
	{
		
		//System.out.println(user);
		boolean f=userService.checkEmail(user.getEmail());;
		
		if(f) {
			System.out.println("Email id already Exists");
		}else 
		{
			
		UserDtls userDtls=userService.createUser(user);
		
		if(userDtls!=null) {
			System.out.println("Register Successfully");
		}else {
			System.out.println("Something error in server");
		}
		}
		return "redirect:/register";
	}

}
