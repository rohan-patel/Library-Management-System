package com.rohan.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long employeeId;

	private String employeeName;
	private String employeeStreet;
	private String employeeCity;
	private String employeeSalary;

	private Gender employeeGender;
	
	public Employee() {
	}

	public Employee(String employeeName, String employeeStreet, String employeeCity, String employeeSalary,
			Gender employeeGender) {
		super();
		this.employeeName = employeeName;
		this.employeeStreet = employeeStreet;
		this.employeeCity = employeeCity;
		this.employeeSalary = employeeSalary;
		this.employeeGender = employeeGender;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeStreet() {
		return employeeStreet;
	}

	public void setEmployeeStreet(String employeeStreet) {
		this.employeeStreet = employeeStreet;
	}

	public String getEmployeeCity() {
		return employeeCity;
	}

	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}

	public String getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(String employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Gender getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(Gender employeeGender) {
		this.employeeGender = employeeGender;
	}

}
