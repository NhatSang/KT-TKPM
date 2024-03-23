package com.se.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.se.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	@Query("select d from Department d where d.id =:id")
	public Department getById(@Param("id") int id);

}
