package com.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.userapp.model.UserDtls;
import com.userapp.service.UserService;

import jakarta.servlet.http.HttpSession;

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
	public String createuser(@ModelAttribute UserDtls user,HttpSession session)
	{
		
		

		boolean f=userService.checkEmail(user.getEmail());
		System.out.println(f);
		
		if(f) {
			session.setAttribute("msg","Email Id already exists");
		}else 
		{
			
		UserDtls userDtls=userService.createUser(user);
		
		if(userDtls!=null) {
			session.setAttribute("msg","Register Sucessfully");
		}else {
			session.setAttribute("msg","Something wrong on server");
		}
		}
		return "redirect:/register";
	}

}
