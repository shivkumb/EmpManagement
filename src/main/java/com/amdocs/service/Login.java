package com.amdocs.service;

import com.amdocs.model.LoginCred;

public interface Login {

	
	public char isValidCred(String username, String password);

	LoginCred getUserDetails();
}
