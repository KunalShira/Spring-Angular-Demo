package com.kunal.employee_management.service;

import java.util.List;

import com.kunal.employee_management.entity.Employee;

public interface EmployeeService {
	public Employee create(Employee employee);

	public void multicreate(List<Employee> theEmployees,boolean b);

	public List findAll();
}
