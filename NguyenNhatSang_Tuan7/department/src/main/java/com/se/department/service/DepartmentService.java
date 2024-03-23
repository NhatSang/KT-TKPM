package com.se.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.department.entity.Department;
import com.se.department.repository.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAll() {
		return departmentRepository.findAll();
	}

	public Department getDepartmentById(int id) {
		return departmentRepository.getById(id);
	}

	public Department save(Department d) {
		return departmentRepository.save(d);

	}
}
