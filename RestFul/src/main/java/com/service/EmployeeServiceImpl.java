package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EmployeeDao;
import com.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	
	@Override
	public Employee createEmployee(Employee employee) {
		Employee employee1 =null;
		if(employee.getPassword().length()>3)
		{
			System.out.println("validation success"); 
		   employee1=this.employeeDao.createEmployee(employee);	
		}
		return employee1;
	}

	@Override
	public List<Employee> readEmployee() {
		// TODO Auto-generated method stub
		return this.employeeDao.readEmployee();
	}

	@Override
	public Employee readEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return this.employeeDao.readEmployeeById(empId);
		
	}

	@Override
	public Employee getEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return this.employeeDao.updateEmployee(employee);
	}

	@Override
	public Employee deleteEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return this.employeeDao.deleteEmployeeById(empId);
	}

}
