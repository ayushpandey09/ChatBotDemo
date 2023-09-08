package com.example.chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.entity.Employee;
import com.example.chatbot.service.EmployeeService;

@RestController
@RequestMapping("/chatbot")
public class EmployeeController {

	@Autowired
	EmployeeService empServ;
	
	String question;
	
	@PostMapping("/question/{prompt}/{id}")
	String postQuestion(@PathVariable("prompt") String prompt, @PathVariable("id") Integer empID){
		if(prompt.contains("manager")) {
			List<Employee> emp = empServ.findManagerByEmpId(empID);
			return emp.get(0).getEmp_name();
		}else {
			return "Sorry... not able to get your prompt";
		}
		
	}
	
	
	
	
}
