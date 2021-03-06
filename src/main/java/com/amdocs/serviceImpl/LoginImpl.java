package com.amdocs.serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.dao.LoginDao;
import com.amdocs.model.Employee;
import com.amdocs.model.LoginCred;
import com.amdocs.service.EmployeeService;
import com.amdocs.service.Login;

@Service
public class LoginImpl implements Login {

	@Autowired
	LoginDao loginDao;
	@Autowired
	EmployeeService employeeService;
	private LoginCred loginCred;
	@Override
	public char isValidCred(String username, String password) {

		loginCred = loginDao.checkValidUser(username, password);
		System.out.println(loginCred);

		if (loginCred.getUsername() != null && loginCred.getPassword() != null && loginCred.getEmployeeID() != null) {

			if (loginCred.getEmployeeID().isActive()) {
				if (loginCred.getIsAdmin())
					return 1;
				else
					return 0;
			}
		}
		return 2;

	}
	

	@Override
	public LoginCred getUserDetails()
	{
		return this.loginCred;
	}
	
	@Autowired
	HttpSession session;
	@Override
	public void logoutActiveUser() {
		session.removeAttribute("username");
		session.invalidate();
	}

}
