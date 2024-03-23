package com.se.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.department.entity.Department;
import com.se.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/all")
	public List<Department> getALL() {
		return departmentService.getAll();
	}

	@GetMapping("/{id}")
	public Department getById(@PathVariable int id) {
		return departmentService.getDepartmentById(id);
	}

	@PostMapping("/save")
	public Department save(@RequestBody Department deparment) {
		return departmentService.save(deparment);
	}
}
