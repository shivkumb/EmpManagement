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
	public LoginCred checkValidUser(String username, String password) {
		
		LoginCred logincred = loginRepo.findByUsernameAndPassword(username, password);
		try {
			if (!logincred.equals(null))
			{
				return logincred;
			}

		} catch (NullPointerException e) {
			return new LoginCred();
		}
		return logincred;
	}

}
