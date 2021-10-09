package com.amdocs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "login_cred")
public class LoginCred {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long objId;
	
	
	
	@Column(name = "username")
	@NotBlank(message = "Username can be empty !!")
	@Size(min = 1,max = 20,message = "Username must be in 5 to 20 characters !!")
	//@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid format for username")
	private String username;
	
	@NotBlank(message = "Password can be empty !!")
	//@Size(min = 1,max = 20,message = "Password must be in 5 to 20 characters !!")
	@Column(name = "password",nullable = false,unique = true)
	private String password;

	@Column(name = "user_role")
	private String role;
	
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	@JsonManagedReference
	private Employee employeeID;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	public long getObjId() {
		return objId;
	}

	public void setObjId(long objId) {
		this.objId = objId;
	}

	public Employee getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Employee employeeID) {
		this.employeeID = employeeID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginCred [objId=" + objId + ", employeeID=" + employeeID + ", username=" + username + ", password="
				+ password + ", role=" + role + "]";
	}

	
	
}
