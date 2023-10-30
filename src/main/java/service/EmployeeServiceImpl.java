package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.model.Employee;

import repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployeesAfterIncomeTaxDeduction() {
		List<Employee> employees = employeeRepository.findAll();

		return employees;
	}

}
