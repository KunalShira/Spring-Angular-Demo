package com.kunal.employee_management.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kunal.employee_management.entity.Employee;
import com.kunal.employee_management.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({ "api" })
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("singleRecord")
	public Employee create(@RequestBody Employee theEmployee) {
		return employeeService.create(theEmployee);
	}

	@PostMapping("multiRecords")
	public ResponseEntity<List<Employee>> multiCreate(@RequestBody List<Employee> theEmployees,
			@RequestHeader("button") boolean b) {
		employeeService.multicreate(theEmployees, b);

		return new ResponseEntity<List<Employee>>(theEmployees, HttpStatus.OK);
	}


	@GetMapping("getAll")
	public List findAll() {
		return employeeService.findAll();
	}

}
