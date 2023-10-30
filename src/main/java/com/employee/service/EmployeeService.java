package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {
	void saveEmployee(Employee employee);

	List<Employee> getEmployeesAfterIncomeTaxDeduction();
}