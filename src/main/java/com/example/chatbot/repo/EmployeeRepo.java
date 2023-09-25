package com.example.chatbot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chatbot.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	@Query(value = "SELECT manager.* FROM employees AS employee JOIN employees AS manager ON employee.manager_id = manager.employee_id WHERE employee.employee_id = :employeeId", nativeQuery =true)
	List<Employee> findManager(@Param("employeeId") Integer employee_id);
	
	@Query(value = "select * from employees where location= :location and designation='IT support'", nativeQuery =true)
	List<Employee> findIThelp(@Param("location") String location);
	
	@Query(value = "select * from employees where employee_id = :employeeId", nativeQuery =true)
	List<Employee> findNwa(@Param("employeeId") Integer employee_id);
	
	 @Query(value = "SELECT COUNT(*) FROM employees WHERE employee_id = :empID", nativeQuery = true)
	 int checkEmpIDExistence(@Param("empID") Integer empID);
	 
	 @Query(value = "SELECT COUNT(*) FROM employees WHERE location = :location", nativeQuery = true)
	 int checkLocationExistence(@Param("location") String location);
}
