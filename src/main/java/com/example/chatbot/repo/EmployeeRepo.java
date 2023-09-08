package com.example.chatbot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.chatbot.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	@Query("SELECT m.empName FROM Employee e JOIN e.manager m WHERE e.id = :employeeId")
	List<Employee> findByManager(@Param("employeeId") Integer employee_id);
	
}
