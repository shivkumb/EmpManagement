package com.amdocs.daoImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amdocs.dao.EmployeeDao;
import com.amdocs.exceptions.EmployeeExceptions;
import com.amdocs.model.Employee;
import com.amdocs.repository.EmployeeRepository;

@Service
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	EmployeeRepository emprepo;
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return emprepo.save(employee);
	}

	@Override
	public Employee getEmployeeByEmpID(int empID) throws EmployeeExceptions {
		
		Employee employee;
		employee = emprepo.findById(empID).orElse(null);
		
		if (employee.equals(null))
		{
			throw new EmployeeExceptions("Invalid employee ID.");
			
		}
		
		return employee;
	}

	@Override
	public Employee getEmployeeByContactNumber(long contactNumber) throws EmployeeExceptions {
		
		Employee employee;
		employee = emprepo.findByContactNumber(contactNumber);
		
		if (employee == null)
		{
			throw new EmployeeExceptions("Invalid contact number.");
			
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeExceptions {
		
		List<Employee> employeeList = emprepo.findAll();
		
		if (!employeeList.isEmpty())
		{
			return employeeList;
		}
		else
		{
			throw new EmployeeExceptions("No active employee available");
		}
	}

	@Override
	public boolean deleteEmployee(Employee employee) throws EmployeeExceptions {
		
		if (emprepo.existsById(employee.getEmployeeID()))
		{
			emprepo.delete(employee);
			
			return true;
		}
		else
		{
			throw new EmployeeExceptions("Employee details not exists, please check details");
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeExceptions {
		
		Employee employeeUpdated;	
		if (emprepo.existsById(employee.getEmployeeID()))
		{
			employeeUpdated = emprepo.save(employee);
			
			return employeeUpdated;
		}
		else
		{
			throw new EmployeeExceptions("Employee details not exists, please check details");
		}
	}

	@Override
	public List<Employee> getAllActiveEmployees() throws EmployeeExceptions {
		
		List<Employee> activeEmployees;
		activeEmployees = emprepo.findByisActive(true);
		if (!activeEmployees.isEmpty())
		{
			return activeEmployees;
		}
		else
		{
			throw new EmployeeExceptions("No active employee available");
		}
		
	}

}
