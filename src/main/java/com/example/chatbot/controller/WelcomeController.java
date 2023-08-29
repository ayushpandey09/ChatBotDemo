package com.example.chatbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcomeMessage(){
		
		String message="Welcome to the ChatBot";
		
		return ResponseEntity.ok(message);
		
	}
	

}
