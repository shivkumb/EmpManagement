package com.amdocs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public Employee findByContactNumber(long contactNumber);

	public List<Employee> findByisActive(boolean isActive);
	
}
