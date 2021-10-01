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

@Entity
@Table(name = "login_cred")
public class LoginCred {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long objId;
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employeeID;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password",nullable = false,unique = true)
	private String password;

	@Column(name = "is_admin")
	private boolean isAdmin;
	
	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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
				+ password + ", isAdmin=" + isAdmin + "]";
	}
	
	
}
