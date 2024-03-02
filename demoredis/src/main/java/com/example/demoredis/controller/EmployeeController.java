package com.example.demoredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoredis.entity.Employee;
import com.example.demoredis.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping
	public List<Employee> getAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		repository.save(employee);
		return employee;
	}
	
	
}
