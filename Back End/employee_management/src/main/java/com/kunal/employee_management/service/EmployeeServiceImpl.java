package com.kunal.employee_management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunal.employee_management.entity.Employee;
import com.kunal.employee_management.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRespository;

	@Override
	public Employee create(Employee theEmployee) {
		return employeeRespository.save(theEmployee);
	}

	@Override
	public void multicreate(List<Employee> theEmployees, boolean button) {
		// TODO Auto-generated method stub
		List<Employee> theEmployeesUpdate = new ArrayList<>();
		theEmployeesUpdate = returnUpdatedList(theEmployees, button);

		theEmployeesUpdate.forEach(c -> employeeRespository.save(c));
	}

	private List<Employee> returnUpdatedList(List<Employee> theEmployees, boolean button) {
		// TODO Auto-generated method stub
		List<Employee> updatedList = new ArrayList<Employee>();
		if (button) {
			// clear
			for (Employee e : theEmployees) {
				if (e.getFirstName() == "" || e.getEmail() == "" || e.getLastName() == "" || e.getContact() == ""
						|| !isValidEmail(e.getEmail()) || !isValidContact(e.getContact())
						|| !isValidName(e.getFirstName()) || !isValidName(e.getLastName())) {
					// return empty list
					return new ArrayList<Employee>();
				} else {
					updatedList.add(e);
				}
			}
			return updatedList;
		} else {
			// non falsy
			for (Employee e : theEmployees) {
				if (e.getFirstName() == "" || e.getEmail() == "" || e.getLastName() == "" || e.getContact() == ""
						|| !isValidEmail(e.getEmail()) || !isValidContact(e.getContact())
						|| !isValidName(e.getFirstName()) || !isValidName(e.getLastName())) {
					// omit this employee
					continue;
				} else {
					updatedList.add(e);
				}
			}
			return updatedList;

		}
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRespository.findAll();
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isValidContact(String contact) {
		String emailRegex = "(0/1)?[1-9][0-9]{9}";

		Pattern pat = Pattern.compile(emailRegex);
		if (contact == null)
			return false;
		return pat.matcher(contact).matches();
	}

	public static boolean isValidName(String name) {
		String emailRegex = "^[A-Z]{1}[a-z]+$";

		Pattern pat = Pattern.compile(emailRegex);
		if (name == null)
			return false;
		return pat.matcher(name).matches();
	}

}
