package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDTO;
import com.employee.responsemodel.EmployeeResponse;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody EmployeeDTO employee) {

		if (employee.getFirstName().isBlank()) {
			return new ResponseEntity<String>("First Name should not be empty.", HttpStatus.PRECONDITION_FAILED);
		}

		if (employee.getLastName().isBlank()) {
			return new ResponseEntity<String>("Last Name should not be empty.", HttpStatus.PRECONDITION_FAILED);
		}

		if (employee.getEmail().isBlank()) {
			return new ResponseEntity<String>("Email should not be empty.", HttpStatus.PRECONDITION_FAILED);
		}

		if (employee.getPhoneNumber().isEmpty()) {
			return new ResponseEntity<String>("There should be atleast one phone number.",
					HttpStatus.PRECONDITION_FAILED);
		}

		// save employee to database
		EmployeeDTO savedEmp = employeeService.saveEmployee(employee);

		return new ResponseEntity<EmployeeDTO>(savedEmp, HttpStatus.OK);
	}

	// display list of employees after income tax deduction
	@GetMapping("/getEmployeesAfterDeduction")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getEmployeesAfterIncomeTaxDeduction() {
		return new ResponseEntity<List<EmployeeResponse>>(employeeService.getEmployeesAfterIncomeTaxDeduction(),
				HttpStatus.OK);
	}
}
