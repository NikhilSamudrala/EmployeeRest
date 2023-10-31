package com.employee.service;

import java.util.List;

import com.employee.dto.EmployeeDTO;
import com.employee.responsemodel.EmployeeResponse;

public interface EmployeeService {
	EmployeeDTO saveEmployee(EmployeeDTO employee);

	List<EmployeeResponse> getEmployeesAfterIncomeTaxDeduction();
}