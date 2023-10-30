package com.employee.model;

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

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long employeeId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Convert(converter = StringListConverter.class)
	@Column(name = "phone_number")
	private List<String> phoneNumber;
	
	@Column(name = "doj")
	private Date doj;
	
	@Column(name = "salary")
	private long salary;
	
	private long yearlySalary;
	
	private double taxAmount;
	 
	private double cessAmount;

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

	public long getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(long yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}
	
}