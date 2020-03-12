package com.hcl.swipe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.swipe.exception.DBException;
import com.hcl.swipe.exception.UserNotFoundException;
import com.hcl.swipe.model.Employee;
import com.hcl.swipe.model.RolesCountData;
import com.hcl.swipe.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping(value="/list")
	public ResponseEntity<List<Employee>> employeDetails() throws UserNotFoundException {
		List<Employee> list=employeeService.fetchEmployees();
		return new ResponseEntity(list, HttpStatus.OK);
		//return list;
	}
	@PostMapping(value="/save")
	public ResponseEntity saveEmployee(@Valid Employee employee) throws DBException{
		return new ResponseEntity(employeeService.saveEmployee(employee),HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity updateEmployee(@Valid  Employee employee,Long id) throws UserNotFoundException, DBException{
		return new ResponseEntity(employeeService.updateEmployee(employee,id),HttpStatus.OK);
	}
	
	@GetMapping(value="/listofemployee")
	public ResponseEntity<List<Employee>> employeDetailsFromHQL() throws UserNotFoundException {
		List<Employee> list=employeeService.getEmployee();
		return new ResponseEntity(list, HttpStatus.OK);
	}
	@GetMapping(value="/roles")
	public ResponseEntity<List<RolesCountData>> employeRoleDetails() throws DBException {
		List<RolesCountData> list=employeeService.getEmployeeUsingNativeQuery();
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
