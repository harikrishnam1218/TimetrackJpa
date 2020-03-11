package com.hcl.swipe.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.swipe.exception.DBException;
import com.hcl.swipe.exception.UserNotFoundException;
import com.hcl.swipe.model.Employee;
import com.hcl.swipe.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> fetchEmployees() throws UserNotFoundException {
	List<Employee> list=	employeeRepository.findAll();
	if(list==null||list.isEmpty()) {
		throw new UserNotFoundException("Employee Records Not Found From DB");
	}
		return list;
	}

	@Override
	public Employee saveEmployee(Employee employee) throws DBException {
		Employee emp=employeeRepository.save(employee);
		if(emp==null) {
			throw new DBException("Employee Data not saved Succesfulluy");
		}
		return emp;
	}

	@Override
	public Employee updateEmployee(Employee employee,Long id) throws UserNotFoundException, DBException {
		Employee emp=findById(id);
		if(emp==null) {
			throw new UserNotFoundException("User details Not Found From Db");
		}
		if(employee.getName()!=null)
		emp.setName(employee.getName());
		if(employee.getRole()!=null)
		emp.setRole(employee.getRole());
		if(employee.getOnboarddate()!=null)
		emp.setOnboarddate(employee.getOnboarddate());
		if(employee.getOnboardloc()!=null)
		emp.setOnboardloc(employee.getOnboardloc());
		Employee eploy=employeeRepository.save(emp);
		if(eploy==null) {
			throw new DBException("Updation failed");
		}
		return eploy;
	}


	@Override
	public Employee findById(Long id) throws UserNotFoundException {
		Optional<Employee>  ee=employeeRepository.findById(id);
		if(!ee.isPresent()) {
			throw new UserNotFoundException("User Details not found From Db ");
		}
		return ee.get();
	}

	@Override
	public List<Employee> getEmployee() throws UserNotFoundException {
		List<Employee> emp=employeeRepository.findAll();
		if(emp==null) {
			throw new UserNotFoundException("Employee Data not found in DB");
		}
		return emp;
	}

	@Override
	public List<Map<String, Object>> getEmployeeUsingNativeQuery() {
		List<Map<String, Object>> listmap=employeeRepository.getEmployeeUsingNativeQuery();
		return listmap;
	}

}
