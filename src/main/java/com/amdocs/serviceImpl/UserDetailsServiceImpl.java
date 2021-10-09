package com.amdocs.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.amdocs.dao.LoginDao;
import com.amdocs.model.LoginCred;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	LoginDao loginDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		LoginCred loginCred= loginDao.findByUsername(username);
		if (loginCred==null)
		{
			throw new RuntimeException("No user found");
		}
		UserDetailsImpl userDetails  = new UserDetailsImpl(loginCred);
		return userDetails;
	}

}
