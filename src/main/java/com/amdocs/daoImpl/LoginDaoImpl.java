package com.amdocs.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.amdocs.dao.LoginDao;
import com.amdocs.model.LoginCred;
import com.amdocs.repository.LoginRepo;


@Service
public class LoginDaoImpl implements LoginDao{

	@Autowired
	LoginRepo loginRepo;
	
	@Override
	public LoginCred findByUsername(String username)
	{
		return loginRepo.findByUsername(username);
	}

}
