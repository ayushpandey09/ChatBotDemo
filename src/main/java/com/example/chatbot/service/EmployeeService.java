package com.example.chatbot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatbot.entity.Employee;
import com.example.chatbot.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired 
	EmployeeRepo empRepo;
	
	public List<Employee> findManagerByEmpId(Integer empId){
		return empRepo.findManager(empId);
	}
	public List<Employee> findIThelp(String location){
		return empRepo.findIThelp(location);
	}
	
}
