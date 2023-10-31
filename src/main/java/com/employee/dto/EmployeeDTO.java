package com.employee.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.employee.repository.StringListConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Employee Object used for service operations.
 */
public class EmployeeDTO implements Serializable {
	/**
	 * For Serialization.
	 */
	private static final long serialVersionUID = 2287969836242192408L;

	@Id
	private long employeeId;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String firstName;

	@NotEmpty
	@Size(max = 100)
	private String lastName;

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	@Convert(converter = StringListConverter.class)
	private List<String> phoneNumber;

	@NotEmpty
	private Date doj;

	@NotEmpty
	private long salary;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
