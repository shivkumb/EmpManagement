package com.amdocs.dao;

import com.amdocs.model.LoginCred;

public interface LoginDao {

	public LoginCred findByUsername(String username);
}
