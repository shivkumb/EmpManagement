package com.amdocs.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amdocs.model.Employee;
@Service
public interface EmployeeService {

	
	public Employee saveEmployee(Employee employee);
	
	public Employee getEmployeeByEmpID(int empID) throws Exception;
	
	public Employee getEmployeeByContactNumber(long contact_number);
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee); 
	
	public List<Employee> getAllActiveEmployees();
	
}
