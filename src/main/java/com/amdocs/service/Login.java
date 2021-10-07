package com.amdocs.service;

import org.springframework.stereotype.Service;
import com.amdocs.model.LoginCred;

@Service
public interface Login {

	
	public char isValidCred(String username, String password);

	public LoginCred getUserDetails();
	
	public void logoutActiveUser();
}
