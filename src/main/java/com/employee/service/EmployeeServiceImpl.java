package com.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.EmployeeEntity;
import com.employee.exception.EmployeeExistsException;
import com.employee.mapper.EmployeeMapper;
import com.employee.repository.EmployeeRepository;
import com.employee.responsemodel.EmployeeResponse;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employee) {
		Optional<EmployeeEntity> emp = employeeRepository.findById(employee.getEmployeeId());
		if (emp.isPresent()) {
			throw new EmployeeExistsException("Conflicting Details Passed", "409");
		}
		EmployeeEntity savedEmp = this.employeeRepository.save(EmployeeMapper.convertToEmployeeEntity(employee));

		return EmployeeMapper.convertToEmployeeDTO(savedEmp);
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<EmployeeResponse> getEmployeesAfterIncomeTaxDeduction() {
		List<EmployeeEntity> employees = employeeRepository.findAll();

		List<EmployeeResponse> output = employees.stream().map(employee -> {
			EmployeeDTO emp = EmployeeMapper.convertToEmployeeDTO(employee);
			int multiplicationFactor = 12;
			int month = emp.getDoj().getMonth();
			month = month > 3 ? month - 2 : month + 10;
			int date = emp.getDoj().getDate();
			multiplicationFactor -= month;
			int salaryForDays = 0;
			if (date > 1 && ((month == 11 && date < 28) || date < 30)) {
				multiplicationFactor -= 1;
				salaryForDays = (int) Math.ceil(emp.getSalary() * date / 30);
			}
			long totalSalary = emp.getSalary() * multiplicationFactor + salaryForDays;

			double incomeTax = 0;
			long slabVal = 0;
			if (totalSalary > 250000) {
				slabVal = totalSalary > 500000 ? 250000 : totalSalary - 250000;
				incomeTax += slabVal * 0.05;
			} else if (totalSalary > 500000) {
				slabVal = totalSalary > 1000000 ? 500000 : totalSalary - 500000;
				incomeTax += slabVal * 0.1;
			} else if (totalSalary > 1000000) {
				slabVal = totalSalary - 1000000;
				incomeTax += slabVal * 0.2;
			}

			double cessAmount = totalSalary > 2500000 ? (totalSalary - 2500000) * 0.02 : 0;

			EmployeeResponse resp = new EmployeeResponse(emp.getEmployeeId(), emp.getFirstName(), emp.getLastName(),
					totalSalary, incomeTax, cessAmount);
			return resp;
		}).collect(Collectors.toList());

		return output;
	}

}
