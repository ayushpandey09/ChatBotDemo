package com.example.chatbot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatbot.entity.Employee;
import com.example.chatbot.entity.Message;
import com.example.chatbot.service.EmployeeService;

@RestController
@RequestMapping("/chatbot")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	@Autowired
	EmployeeService empServ;
	
	String question;
	String username;
	
	@PostMapping("/question")
	ResponseEntity<Message> postQuestion(@RequestBody Message msg){
		
		if(msg.getContent().contains("manager")) 
			question = "manager";
		else if(msg.getContent().contains(" it help"))
			question = "IT";
		else if(msg.getContent().contains(" nwa "))
			question = "nwa";
		else if(msg.getContent().contains("exit"))
			question = "exit";
		else
			question = "";
		
		username = msg.getSenderName();
		empServ.addMessage(msg);
			
		return ResponseEntity.ok(msg);

	}
	
	@GetMapping("/questionresponse")
	ResponseEntity<Message> getResponse() {
		Message msg;
			if(question == "manager" ) {
				msg = new Message("Chatbot", "Enter your employee id");
				
			}
				
			else if(question == "IT") {
				msg = new Message("Chatbot", "Enter your location");
				
			}
			else if(question == "nwa") {
				msg = new Message("Chatbot", "Enter your employee ID");
			}
			
			else if(question == "exit") {
//				msg = new Message("Chatbot","Enter your email ID");
//				empServ.endChatAndSendTranscript();
				msg = new Message("Chatbot","Confirm if you want to exit");
			}
				
			else {
				msg = new Message("Chatbot", "Sorry... not able to get your prompt");
				
			}
			
			empServ.addMessage(msg);
			return ResponseEntity.ok(msg);
				
		}
	

	
	@GetMapping("/questionnwa/{id}")
	ResponseEntity<Message> getNwa(@PathVariable("id") Integer empID) {
		
		Message msg;
	
		if(empServ.checkEmpId(empID) != 0)
		{
			List<Employee> emp = empServ.findNwaCode(empID);
			msg = new Message("Chatbot", "Your Nwa code : " + emp.get(0).getNwa_code());
			
		}
		else
		{
			 msg = new Message("Chatbot", "Invalid Employee ID!");
			
		}
		empServ.addMessage(new Message(username,"Employee ID: " + empID.toString()));
		empServ.addMessage(msg);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/questionmanager/{id}")
	ResponseEntity<Message> getId(@PathVariable("id") Integer empID) {
		
		Message msg;
		if(empServ.checkEmpId(empID) != 0)
		{
			List<Employee> emp = empServ.findManagerByEmpId(empID);
			 msg = new Message("Chatbot", emp.get(0).getEmp_name()+ "\n : " + emp.get(0).getEmail());
			
		}
		else
		{
			 msg = new Message("Chatbot", "Invalid Employee ID!");
			
		}
		empServ.addMessage(new Message(username,"Employee ID: " + empID.toString()));
		empServ.addMessage(msg);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/questionithelp/{location}")
	ResponseEntity<Message> getId(@PathVariable("location") String location) {
		
		Message msg;
		
		if(empServ.checkLocation(location) != 0)
		{
			List<Employee> emp = empServ.findIThelp(location);
			 msg = new Message("Chatbot", emp.get(0).getEmp_name() + "\n : " + emp.get(0).getEmail());
			
		}
		else
		{
			 msg = new Message("Chatbot", "wrong prompt");
			
		}
		empServ.addMessage(new Message(username,"Location: " + location));
		empServ.addMessage(msg);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/chattranscript/{email}")
	String getChatTranscript(@PathVariable String email) {
		if(question=="exit") {
			empServ.endChatAndSendTranscript(email);
			return "Chat Transcript has been delivered to your email";
		}
		else
			return "Please end the chat first to get trancsript";
	}
	
}

//End-points
//For IT -----------------------------------------------
//POST : http://localhost:8080/chatbot/question/ IT help
//GET : http://localhost:8080/chatbot/questionresponse
//GET : http://localhost:8080/chatbot/questionithelp/hyderabad

//For Manager -----------------------------------------------
//POST : http://localhost:8080/chatbot/question/who is manager
//GET : http://localhost:8080/chatbot/questionresponse
//GET : http://localhost:8080/chatbot/questionmanager/1050

