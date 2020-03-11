package com.hcl.swipe.service;

import java.util.List;
import java.util.Map;

import com.hcl.swipe.exception.DBException;
import com.hcl.swipe.exception.UserNotFoundException;
import com.hcl.swipe.model.Employee;

public interface EmployeeService {

	List<Employee> fetchEmployees() throws UserNotFoundException ;
	Employee saveEmployee(Employee employee) throws DBException;
	Employee updateEmployee(Employee employee,Long id) throws UserNotFoundException, DBException ;
	Employee findById(Long id) throws UserNotFoundException;
	List<Employee> getEmployee() throws UserNotFoundException ;
	List<Map<String, Object>> getEmployeeUsingNativeQuery();
}
