package com.amdocs.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/validatelogin")
	public ModelAndView validateLoginCred(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		ModelAndView mv = new ModelAndView();

		switch (login.isValidCred(username, password)) {
		case 0: {
			
			LoginCred loginCred = login.getUserDetails();
			ModelAndView mvc = new ModelAndView("EmpHome","empDetails", loginCred.getEmployeeID());
			request.getSession().setAttribute("username", loginCred.getUsername());
			return mvc;
		}
		case 1: {
			mv.setViewName("AdminHome");
			mv.addObject("firstName",login.getUserDetails().getEmployeeID().getFirstName());
			mv.addObject("lastName",login.getUserDetails().getEmployeeID().getLastName());
			mv.addObject("employeeID",login.getUserDetails().getEmployeeID().getEmployeeID());
			return mv;
		}
		default:
			mv.setViewName("Login");
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
