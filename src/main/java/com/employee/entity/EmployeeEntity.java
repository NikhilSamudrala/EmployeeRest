package com.employee.entity;

import java.sql.Date;
import java.util.List;

import com.employee.repository.StringListConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

/**
 * Employee object used for DB operations.
 */
@Entity
@Table(name = "employees")
public class EmployeeEntity {

	@Id
	@NotEmpty
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;

	@NotEmpty
	@Size(min = 2, max = 100)
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty
	@Size(max = 100)
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty
	@Email
	@Column(name = "email")
	private String email;

	@NotEmpty
	@Convert(converter = StringListConverter.class)
	@Column(name = "phone_number")
	private List<String> phoneNumber;

	@NotEmpty
	@Column(name = "doj")
	private Date doj;

	@NotEmpty
	@Column(name = "salary")
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
		this.phoneNumber.addAll(phoneNumber);
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.add(phoneNumber);
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