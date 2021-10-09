package com.amdocs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.amdocs.config.LoginConfig;
import com.amdocs.model.Employee;
import com.amdocs.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	LoginConfig loginConfig;
	
	
	@PostMapping(name = "/saveEmployee",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee saveEmployee(@Valid @RequestBody Employee employee,BindingResult result)
	{
		System.out.println("Before Set up Save: "+employee);
		
		if (result.hasErrors()) {
			System.out.println("in has error");
			return new Employee();
		}

		employee.setActive(true);
		employee.getLoginCred().setUsername(employee.getEmail());
		employee.getLoginCred().setPassword(loginConfig.getPasswordEncoder().encode(employee.getLoginCred().getPassword()));
		employee.getLoginCred().setRole("ROLE_USER");
		System.out.println("Before Emp Save: "+employee);
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
