package com.amdocs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.service.Login;

@Controller
public class LoginController {

	@Autowired
	Login login;
	
	@RequestMapping("/login")
	public String redirectToLoginPage()
	{
		
		
		return "Login";
	}
	
	@RequestMapping("/validatelogin")
	public ModelAndView validateLoginCred(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		ModelAndView mv = new ModelAndView();

		switch (login.isValidCred(username, password)) {
		case 0: {
			System.out.println("CASE 0");
			mv.setViewName("EmpHome");
			mv.addObject("loginStatus", "User Login Successful");
			return mv;
		}
		case 1: {
			System.out.println("CASE 1");
			mv.setViewName("AdminHome");
			mv.addObject("loginStatus", "Admin Login Successful");
			return mv;
		}
		default:
			System.out.println("CASE Default");
			mv.setViewName("Login");
			mv.addObject("loginStatus", "Something went wrong,try with valid creditials");
			return mv;
		}
	}
}
