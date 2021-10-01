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
		
		System.out.println("in rediect to loginPage method");
		return "Login";
	}
	
	@RequestMapping("/validatelogin")
	public ModelAndView validateLoginCred(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		ModelAndView mv = new ModelAndView();

		switch (login.isValidCred(username, password)) {
		case 0: {
			mv.setViewName("EmpHome");
			mv.addObject("firstName",login.getUserDetails().getEmployeeID().getFirstName());
			mv.addObject("lastName",login.getUserDetails().getEmployeeID().getLastName());
			return mv;
		}
		case 1: {
			mv.setViewName("AdminHome");
			mv.addObject("firstName",login.getUserDetails().getEmployeeID().getFirstName());
			mv.addObject("lastName",login.getUserDetails().getEmployeeID().getLastName());
			return mv;
		}
		default:
			mv.setViewName("Login");
			mv.addObject("loginStatus", "Something went wrong,try with valid creditials");
			return mv;
		}
	}
}
