package com.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	//@Transactional
	public Employee createEmployee(Employee employee) {
		System.out.println("inside create dao");
		Session session =this.sessionFactory.openSession();
		Transaction transObj = session.beginTransaction();
		session.save(employee);
		transObj.commit();
		return employee;
		
	}

	public List<Employee> readEmployee() {
		Session session=this.sessionFactory.openSession();
		String readEmplo="from Employee";
		List<Employee> employees = session.createQuery(readEmplo).list();
		return employees;
	}

	public Employee readEmployeeById(int empId) {
		Session session=this.sessionFactory.openSession();
		String hqlRead="FROM Employee alais WHERE alais.empId=:id";
		List<Employee> emp2=session.createQuery(hqlRead).setParameter("id", empId).list();
		return emp2.get(0);
	}

	public Employee getEmployeeByName(String empName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee updateEmployee(Employee employee) {
		Session session =this.sessionFactory.openSession();
		Transaction transObj = session.beginTransaction();
		String query = "update Employee set empName = vijay where empId = 13";
		List<Employee> emp2=session.createQuery(query).list();/*.setParameter("empname",employee.getEmpName()).setParameter("id", employee.getEmpId()).list();*/
		transObj.commit();
		return emp2.get(0);
	}

	public Employee deleteEmployeeById(int empId) {
		Session session=this.sessionFactory.openSession();
		Transaction transObj = session.beginTransaction();
		String hqlRead="delete Employee WHERE empId=:id";
		Query query=session.createQuery(hqlRead).setParameter("id", empId);
		
		/*List<Employee> emp2=session.createQuery(hqlRead).setParameter("id", empId).list();*/
		int row=query.executeUpdate();
		transObj.commit();
		return null;
		/*Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String HQL_Query="delete Login_User where id="+id;
		Query query=session.createQuery(HQL_Query);
		int row=query.executeUpdate();
		tx.commit();*/
	}
	
	

}
