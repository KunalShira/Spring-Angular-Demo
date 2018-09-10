package com.kunal.employee_management.repo;

import org.springframework.data.repository.CrudRepository;

import com.kunal.employee_management.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
}
