package com.amdocs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amdocs.model.Employee;
import com.amdocs.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/saveEmployee")
	public Employee saveEmployee(Employee employee)
	{
		
		employeeService.saveEmployee(employee);
		
		return employee;
		
	}
}
