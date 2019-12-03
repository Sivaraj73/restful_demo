package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmployeeDao;
import com.model.Employee;
import com.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/readall")
	List<Employee> readAll() {
		return employeeDao.readEmployee();
	}

	@PostMapping(value = "/create")
	public Employee createEmployee(@RequestBody Employee employee)
	{
               /*return this.employeeDao.createEmployee(employee);*/
		return this.employeeService.createEmployee(employee);
	}
	
	@GetMapping(value="/readbyid/{abc}")
	public Employee readEmployeeById(@PathVariable("abc") int empId)
	{
		return this.employeeService.readEmployeeById(empId);
	}
	
	@PutMapping(value="/update")
	public Employee updateEmployee(Employee employee)
	{
		return this.employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping(value="/delete/{def}")
	public Employee deleteEmployee(@PathVariable("def") int empId)
	{
		return this.employeeService.deleteEmployeeById(empId);
	}

}
