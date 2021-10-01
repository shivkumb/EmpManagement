package com.amdocs.dao;

import java.util.List;
import java.util.Optional;

import com.amdocs.exceptions.EmployeeExceptions;
import com.amdocs.model.Employee;

public interface EmployeeDao {

	public Employee saveEmployee(Employee employee);
	
	public Employee getEmployeeByEmpID(int empID) throws EmployeeExceptions;
	
	public Employee getEmployeeByContactNumber(long contactNumber) throws EmployeeExceptions;
	
	public List<Employee> getAllEmployees() throws EmployeeExceptions;
	
	public boolean deleteEmployee(Employee employee) throws EmployeeExceptions;
	
	public Employee updateEmployee(Employee employee) throws EmployeeExceptions; 
	
	public List<Employee> getAllActiveEmployees() throws EmployeeExceptions;
}
