package com.amdocs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.model.LoginCred;
import com.amdocs.service.Login;

@Controller
public class LoginController {

	@Autowired
	Login login;

	@RequestMapping("/login")
	public String redirectToLoginPage(Model model) {

		System.out.println("in rediect to loginPage method");
		model.addAttribute("loginDetails", new LoginCred());
		return "Login";
	}
}
