package com.se.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
