package com.amdocs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.amdocs.serviceImpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class LoginConfig extends WebSecurityConfigurerAdapter{

	
	@Bean
	public UserDetailsService getDetailsService()
	{
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(getDetailsService());
		return authenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(this.daoAuthenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/**").hasRole("ADMIN")
		.antMatchers("/admin/**").hasRole("USER")
		.antMatchers("/**").permitAll().and().formLogin().loginPage("/login")
		.loginProcessingUrl("/admin/empl")
		.successForwardUrl("/user/empl")
		.failureForwardUrl("/loginerror")
		.and().csrf().disable();
		
	}
	
	
}
