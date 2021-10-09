package com.amdocs.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.model.LoginCred;

@Repository
public interface LoginRepo extends JpaRepository<LoginCred, String>{

	public LoginCred findByUsername(String username);
}
