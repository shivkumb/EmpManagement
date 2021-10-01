package com.amdocs.exceptions;

public class EmployeeExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public EmployeeExceptions(String string) {
		// TODO Auto-generated constructor stub
	}


	public String employeeNotFound()
	{
		String exceptionMsg = "Employee Not found with this Employee ID, Please try with correct one.";
		
		return exceptionMsg;
	}
}
