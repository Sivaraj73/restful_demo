package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeService 
{
	public abstract Employee createEmployee(Employee employee);

	public abstract List<Employee> readEmployee();
	
	public abstract Employee readEmployeeById(int empId);
	
	public abstract Employee getEmployeeByName(String empName);
	
	public abstract Employee updateEmployee(Employee employee);
	
	public abstract Employee deleteEmployeeById(int empId);
}
