package com.abc.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}

