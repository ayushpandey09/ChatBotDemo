package com.example.chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/question/{prompt}")
	ResponseEntity<String> postQuestion(@PathVariable("prompt") String prompt){
		
		if(prompt.contains(" manager ")) 
			question = "manager";
		else if(prompt.contains(" IT help"))
			question = "IT";
		else
			question = "";
			
		return ResponseEntity.ok(prompt);

	}
	
	@GetMapping("/questionresponse")
		String getResponse() {
			if(question == "manager" )
				return "Enter your id number";
			else if(question == "IT")
				return "Enter you location";
			else
				return "Sorry... not able to get your prompt";
		}
	
	
		
	@GetMapping("/questionmanager/{id}")
	String getId(@PathVariable("id") Integer empID) {
		
		if(question == "manager")
		{
			List<Employee> emp = empServ.findManagerByEmpId(empID);
			return emp.get(0).getEmp_name();
		}
		else
		{
			return "wrong prompt";
		}
	}
	
	@GetMapping("/questionithelp/{location}")
	String getId(@PathVariable("location") String location) {
		
		if(question == "IT")
		{
			List<Employee> emp = empServ.findIThelp(location);
			return emp.get(0).getEmp_name();
		}
		else
		{
			return "wrong prompt";
		}
	}
	
}

//End-points
//For IT -----------------------------------------------
//POST : http://localhost:8080/chatbot/question/ IT help
//GET : http://localhost:8080/chatbot/questionresponse
//GET : http://localhost:8080/chatbot/questionithelp/hyderabad

//For Manager -----------------------------------------------
//POST : http://localhost:8080/chatbot/question/ manager
//GET : http://localhost:8080/chatbot/questionresponse
//GET : http://localhost:8080/chatbot/questionmanager/1050

