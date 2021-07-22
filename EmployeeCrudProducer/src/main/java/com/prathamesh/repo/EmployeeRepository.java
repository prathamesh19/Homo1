package com.prathamesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prathamesh.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
