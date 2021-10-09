package com.amdocs.serviceImpl;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.amdocs.model.LoginCred;

public class UserDetailsImpl implements org.springframework.security.core.userdetails.UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginCred loginCred;

	public UserDetailsImpl(LoginCred loginCred) {
		this.loginCred = loginCred;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(loginCred.getRole());
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		
		return loginCred.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return loginCred.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return loginCred.getEmployeeID().isActive();
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
