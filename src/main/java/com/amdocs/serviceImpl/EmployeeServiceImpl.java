package com.amdocs.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.dao.EmployeeDao;
import com.amdocs.exceptions.EmployeeExceptions;
import com.amdocs.model.Employee;
import com.amdocs.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		 
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public Employee getEmployeeByEmpID(int empID) {
		 
		try {
			return employeeDao.getEmployeeByEmpID(empID);
		} catch (EmployeeExceptions e) {
			
			return new Employee();
		}
		
	}

	@Override
	public Employee getEmployeeByContactNumber(long contact_number) {
		 
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		 
		return null;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		 
		return false;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
	
		return null;
	}

	@Override
	public List<Employee> getAllActiveEmployees() {
		
		return null;
	}
}
