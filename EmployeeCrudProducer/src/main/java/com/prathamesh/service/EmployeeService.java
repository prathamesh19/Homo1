package com.prathamesh.service;

import com.prathamesh.model.Employee;

@FunctionalInterface
public interface EmployeeService {

	public Integer saveOneEmployee(Employee employee);
	
	
}
