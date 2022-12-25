package com.rohan.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohan.lms.model.Book;
import com.rohan.lms.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
