package com.hcl.swipe.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.swipe.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
@Query("from employee")
public List<Employee> getEmployee();
@Query(value="select role as role,count(*) as count from employee group by role ",nativeQuery=true)
public List<Map<String, Object>> getEmployeeUsingNativeQuery();

}
