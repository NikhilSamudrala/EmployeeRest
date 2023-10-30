package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.model.Employee;

import service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	
	@PostMapping("/saveEmployee")
	public void saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save employee to database
		employeeService.saveEmployee(employee);
	}
	
	
	// display list of employees after income tax deduction
	@GetMapping("/getEmployeesAfterDeduction")
	public List<Employee> getEmployeesAfterIncomeTaxDeduction(Model model) {
		return employeeService.getEmployeesAfterIncomeTaxDeduction();		
	}
}
