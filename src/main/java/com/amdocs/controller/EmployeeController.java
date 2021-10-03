package com.amdocs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/updateEmployee")
	public Employee updateEmployee(Employee employee)
	{
		
		employeeService.saveEmployee(employee);
		
		return employee;
		
	}
	
	@RequestMapping("/deleteEmployee/{employeeID}")
	public Employee deleteEmployee(int employeeID)
	{
		
		Employee employee = null;
		
		return employee;
		
	}
	
	/*@RequestMapping("/getEmployee")
	public Employee getEmployee(@RequestParam("employeeID") int employeeID)
	{
		
		Employee employee = employeeService.getEmployeeByEmpID(employeeID);
		ModelAndView mv = new ModelAndView();
		mv.addObject("employee",employee);
		return employee;
		
	}*/
	@RequestMapping(value = "/getSelfDetails",method = RequestMethod.GET)
	public ModelAndView getSelfDetails(@RequestParam("employeeID") int employeeID)
	{
		
		Employee employee = employeeService.getEmployeeByEmpID(employeeID);
		ModelAndView mv = new ModelAndView("EmpDetails");
		mv.addObject("employee",employee);
		return mv;
		
	}
}
