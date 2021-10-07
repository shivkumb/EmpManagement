package com.amdocs.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.model.LoginCred;
import com.amdocs.service.Login;


@Controller
@SessionAttributes("empCred")
public class LoginController {

	@Autowired
	Login login;
	
	@Autowired
	private HttpServletRequest request;
	
	
	@RequestMapping("/login")
	public String redirectToLoginPage()
	{
		
		System.out.println("in rediect to loginPage method");
		return "Login";
	}
	
	@RequestMapping(path = "/validatelogin",method = RequestMethod.GET)
	public ModelAndView validateLoginCred(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		

		switch (login.isValidCred(username, password)) {
		case 0: {
			
			LoginCred loginCred = login.getUserDetails();
			ModelAndView mvc = new ModelAndView("EmpHome","empDetails", loginCred.getEmployeeID());
			return mvc;
		}
		case 1: {
			LoginCred loginCred = login.getUserDetails();
			ModelAndView mvc = new ModelAndView("AdminHome","empDetails", loginCred.getEmployeeID());
			return mvc;
		}
		default:
			ModelAndView mv = new ModelAndView("Login");
			mv.addObject("loginStatus", "Something went wrong,try with valid creditials");
			return mv;
		}
	}
	
	@RequestMapping("/logout")
	public String userLogout()
	{
		login.logoutActiveUser();
		return "Login";
	}
}
