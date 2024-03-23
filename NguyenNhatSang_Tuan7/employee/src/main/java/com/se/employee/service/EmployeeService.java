package com.se.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.se.employee.dto.Department;
import com.se.employee.dto.EmployeeDTO;
import com.se.employee.entity.Employee;
import com.se.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<EmployeeDTO> getAll() {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

		employeeRepository.findAll().forEach((e) -> {
			Department d = restTemplate.getForObject("http://localhost:8082/departments/" + e.getDepartmentId(),
					Department.class);
			list.add(new EmployeeDTO(e.getId(), e.getName(), d));
		});

		return list;
	}

	public Employee save(Employee e) {
		return employeeRepository.save(e);
	}
}
