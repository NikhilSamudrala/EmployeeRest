package controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;

import service.EmployeeService;

@RestController
@Validated
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestParam(value = "employee.employeeId", required = true) long employeeId,
			@RequestParam(value = "employee.firstName", required = true) String firstName,
			@RequestParam(value = "employee.lastName", required = true) String lastName,
			@RequestParam(value = "employee.email", required = true) String email,
			@RequestParam(value = "employee.phoneNumber", required = true) List<String> phoneNumber,
			@RequestParam(value = "employee.doj", required = true) Date doj,
			@RequestParam(value = "employee.salary", required = true) long salary) {
		// save employee to database
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		employee.setPhoneNumber(phoneNumber);
		employee.setDoj(doj);
		employee.setSalary(salary);
		
		employeeService.saveEmployee(employee);

		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	// display list of employees after income tax deduction
	@GetMapping("/getEmployeesAfterDeduction")
	public List<Employee> getEmployeesAfterIncomeTaxDeduction(Model model) {
		return employeeService.getEmployeesAfterIncomeTaxDeduction();
	}
}
