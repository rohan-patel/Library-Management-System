package com.rohan.lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.lms.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;
	
	/* 
	 * GET - get all employees
	 * GET - get employee by id
	 * POST - add an employee
	 * PUT - update an employee details by id
	 * DELETE - remove an employee by id
	 *  */
}
